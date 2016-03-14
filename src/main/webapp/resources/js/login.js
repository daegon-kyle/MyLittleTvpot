// 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('f7344b855230ef533af89967c6b24efc');

// 카카오 로그인 버튼을 생성합니다.
Kakao.Auth.createLoginButton({
	container : '#kakao-login-btn',
	success : function(authObj) {
		// 로그인 성공시, API를 호출합니다.
		var refreshToken = Kakao.Auth.getRefreshToken();
		var url = $('#url').val();
		
		Kakao.API.request({
			url : '/v1/user/me',
			success : function(res) {				
				var userInfo = JSON.parse(JSON.stringify(res));
				
				var userId = userInfo.id;
				var profile_image;
				var userNickname;
				try {
					userNickname = userInfo.properties.nickname;
					profile_image = userInfo.properties.profile_image;
				}
				catch(e){
					userNickname = '닉네임1';
					profile_image = '/mlpot/resources/img/kakao.png';
				}

				$.ajax({
					type: "POST",
					url: "loginToClipList.do",
					timeout: 1000,
					dataType: "text",
					data: {
						"userId": userId,
						"userNickname": userNickname,
						"profile_image": profile_image 
					},
					success: function(data) {
						console.log(url);
						
						if (url == 'myPot') {
							window.location.href="showMyPot.do";
						}
						else if (url.includes('addClip')) {
							var AfterEqual = url.substring(url.indexOf("=")+1);
							var clipId = AfterEqual.substring(AfterEqual.indexOf("p")+1);
							
							$.ajax({
								type: "POST",
								url: "addClipToMyPot.do",
								timeout: 1000,
								dataType: "text",
								data: {
									"clipId": clipId
								},
								statusCode: {
									400: function() {
										alert("이미 담기하셨습니다.");
										window.location.href="clipView.do?clipId="+clipId;
									}
								},
								success: function() {
									alert("담기 성공하였습니다.");
									window.location.href="clipView.do?clipId="+clipId;
								}
							});
						}
						else if (url.includes('addLike')) {
							var AfterEqual = url.substring(url.indexOf("=")+1);
							var clipId = AfterEqual.substring(AfterEqual.indexOf("e")+1);
							
							$.ajax({
								type: "POST",
								url: "addLike.do?clipId="+clipId,
								timeout: 1000,
								dataType:"text",
								statusCode: {
									400: function(data){
										alert("이미 좋아요 누르셨습니다.");
										window.location.href="clipView.do?clipId="+clipId;
									}
								},
								success: function(){
									alert("좋아요 누르셨습니다.")
									window.location.href="clipView.do?clipId="+clipId;
								}
							});
						}
						else if (url.includes('regiComment')) {
							var AfterEqual = url.substring(url.indexOf("=")+1);
							var clipId = AfterEqual.substring(AfterEqual.indexOf("t")+1);
							
							window.location.href="clipView.do?clipId="+clipId;
						}
						else if (url.includes('clipView')) {
							var AfterEqual = url.substring(url.indexOf("=")+1);
							var clipId = AfterEqual.substring(AfterEqual.indexOf("w")+1);
							
							window.location.href="clipView.do?clipId="+clipId;
						}
						else {
							console.log('hi');
							window.location.href="openClipList.do";
						}
					},
					error: function(xhr, status, error) {
						alert('로그인 실패하였습니다. 다시 시도해주세요.');
					}
				})
			},
			fail : function(error) {
				alert(JSON.stringify(error));
			}
		});
	},
	fail : function(error) {
		alert(JSON.stringify(error));
	}
});
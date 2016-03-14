$(document).ready(function(){
	$('#login').bind('click', function(event){
		location.href="login.do";
		event.preventDefault();
	});
});
$(document).ready(function(){
	$('#loginInClipView').bind('click', function(event){
		var clipId = $('#like').val();
		
		location.href="loginByDiffAddress.do?url=clipView"+clipId;
		event.preventDefault();
	});
});
$(document).ready(function() {
	$('#myPot').bind('click', function(event) {
		$.ajax({
			url: "checkSession.do",
			timeout: 1000,
			dataType:"text",
			success: function(data){
				sessionAvail = JSON.parse(data);
				
				if (!sessionAvail) {
					window.location.href = "loginByDiffAddress.do?url=myPot";
					event.preventDefault();
				}
				else {
					window.location.href = "showMyPot.do";
				}
			},
			error: function(data) {
				alert("error");
			}
		})
	})
});
//사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('f7344b855230ef533af89967c6b24efc');

$(document).ready(function(){
	$('#logout').bind('click', function(event){
		Kakao.Auth.logout(logout());
		
		event.preventDefault();
	});
});
function logout(){
	$.ajax({
		url: "logout.do",
		timeout: 1000,
		dataType:"text",
		success: function(data){
			alert('로그아웃 했습니다.');
			window.location.href = "openClipList.do";
		},
		error: function(data) {
			alert("로그아웃 실패했습니다.");
		}
	})
}
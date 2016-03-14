$(document).ready(function() {
	$("#addClip").bind('click', function checkSession(event) {
		var clipId = $('#clip_id').val();
		var isExistentInMyPot = $('#isExistent').attr('data-isExistentInMyPot');
		
		$.ajax({
			url : "checkSession.do",
			timeout : 1000,
			dataType : "text",
			success : function(data) {
				isSession = JSON.parse(data);
				if (!isSession) {
					window.location.href="loginByDiffAddress.do?url=addClip"+clipId;
					event.preventDefault();
				} else {
					if (isExistentInMyPot == 'true') {
						alert("이미 담기 하셨습니다.");
					}
					else {
						$.ajax({
							type : "POST",
							url : "addClipToMyPot.do",
							timeout : 1000,
							data : {
								"clipId" : clipId
							},
							dataType : "text",
							success : function(data) {
								alert("담기 성공하였습니다.");
							}
						});	
					}
				}
			}
		})
	});
});
$(document).ready(function(){
	$('#like').bind('click', function(event){
		var clipId = $('#like').val();
		var numOfLike = parseInt($('#like').attr("data-numOfLike"))+1;
		
		$.ajax({
			url: "checkSession.do",
			timeout: 1000,
			dataType:"text",
			success: function(data){
				sessionAvail = JSON.parse(data);
				if (!sessionAvail) {
					window.location.href="loginByDiffAddress.do?url=addLike"+clipId;
					event.preventDefault();
				}
				else {
					$.ajax({
						type: "POST",
						url: "addLike.do?clipId="+clipId,
						timeout: 1000,
						dataType:"text",
						statusCode: {
							400: function(data){
								alert("이미 좋아요 누르셨습니다.");
							}
						},
						success: function(data){
							var likeButton = document.getElementById('like');
							var str = "<i class='fa fa-thumbs-o-up'></i> "+numOfLike;
							likeButton.innerHTML = str;
						}
					});
				}
			}
		})
	});
});
$(document).ready(function(){
	$('#comment').bind('click', function(event){
		var clipId = $('#like').val();
		$.ajax({
			url: "checkSession.do",
			timeout: 1000,
			dataType:"text",
			success: function(data){
				sessionAvail = JSON.parse(data);
				if (!sessionAvail) {
					alert("로그인해야 댓글 쓰기가 가능합니다.");
					window.location.href="loginByDiffAddress.do?url=regiComment"+clipId;
					event.preventDefault();
				}
			}
		});
	});
});
$(document).ready(function() {
	$('#clip_id').bind('click', function(event){
		regiComment(event);
	});
});

function regiComment(event){
	event.stopPropagation();
	var comment = $('#comment').val();
	var clipId = $('#clip_id').val();
	
	if (comment.length > 0) {
		$.ajax({
			type:"POST",
			url: "regiComment.do",
			timeout: 1000,
			data: {"clipId":clipId, "comment": comment},
			dataType:"text",
			success: function(data){
				alert("댓글을 등록하셨습니다."); 
				var commentListArea = document.getElementById("commentListArea");
				newComment = JSON.parse(data);
				var str="";
				console.log(newComment);
				var date = new Date(newComment.regDttm);
				str += "<li class='media'> <a class='pull-left' href='#'> <img class='media-object userImage' src="+newComment.user_profile_image+"></a>";
				str += "<div class='media-body'> <span class='name'>"+newComment.user_nickname+"</span>";
				str += "<span class='date'> "+date.customFormat("#YYYY#-#MM#-#DD# #hh#:#mm#:#ss#.0")+"</span>";
				str += "<a href='#' class='delComment pull-right' data-commentId="+newComment.id+" data-original-title='삭제'><i class='fa fa-times'></i></a>";
				str += "<p>"+newComment.content+"</p> </div> </li>";
				
				commentListArea.innerHTML += str;
				
				window.scrollTo(0, document.body.scrollHeight);
				
				$('#clip_id').unbind('click');
				$('#clip_id').bind('click', function(event){
					regiComment(event);
				});
			},
			error: function(){
				alert("댓글을 등록할 수 없습니다.");
			}
		})
	}
	else {
		alert("댓글을 입력해주세요.");
	}
};
Date.prototype.customFormat = function(formatString){
	  var YYYY,MM,M,DD,D,hh,h,mm,ss;
	  YYYY=this.getFullYear();
	  MM = (M=this.getMonth()+1)<10?('0'+M):M;
	  DD = (D=this.getDate())<10?('0'+D):D;
	  formatString = formatString.replace("#YYYY#",YYYY).replace("#MM#",MM).replace("#M#",M).replace("#DD#",DD);
	  h=this.getHours();
	  hh = h<10?('0'+h):h;
	  mm=(m=this.getMinutes())<10?('0'+m):m;
	  ss=(s=this.getSeconds())<10?('0'+s):s;
	  return formatString.replace("#hh#",hh).replace("#h#",h).replace("#mm#",mm).replace("#ss#",ss);
};
$(document).ready(function(){
	$('#commentListArea').bind('click', function(event){
		if ($(event.target).parent().attr('class') == 'delComment pull-right') {
			deleteComment(event);
		}
	});
});

function deleteComment(event){
	event.stopPropagation();
	var delCommentId = $(event.target).parent().attr("data-commentId");
	var clipId = $('#commentListArea').attr("data-clipId");
	
	$.ajax({
		type:"POST",
		url:"delComment.do",
		timeout: 1000,
		data: {"delCommentId":delCommentId, "clipId":clipId},
		dataType:"text",
		success: function(data){
			isSuccess = JSON.parse(data);
			
			if (isSuccess) {
				alert("댓글을 삭제하셨습니다.");
				
				$('#comment'+delCommentId).remove();
				$('#commentListArea').unbind('click');
				$('#commentListArea').bind('click', function(event){
					if ($(event.target).parent().attr('class') == 'delComment pull-right') {
						deleteComment(event);
					}
				});
			}
			else {
				alert("본인만 댓글 삭제할 수 있습니다.");
			}
		},
		error: function(){
			alert("댓글을 삭제할 수 없습니다.");
		}
	})
}
var addNumOfPlayListener = addEventListener('blur', function() {
	if(document.activeElement === document.getElementById('iPlayer')) {
		var clipId = $('#commentListArea').attr("data-clipId");
		var numOfPlay = $('#like').attr('data-numOfPlay');
		
		$.ajax({
			type: 'POST',
			url: 'addNumOfPlay.do',
			timeout: 1000,
			data: {
				'clipId': clipId, 
				'numOfPlay': numOfPlay
			},
			dataType: 'text',
			error: function(data) {
				alert('play 증가 실패');
			}
		});
	}
    removeEventListener(addNumOfPlayListener);
});
//moreClips in firstpage
$(document).ready(function(){
	var firstClipId = 0;

	$('#moreClips').bind('click', function(){
		firstClipId += 20;

		$.ajax({
			type:"POST",
			url:"moreClips.do",
			timeout: 1000,
			data: {
				"firstClipId":firstClipId
			},
			dataType:"text",
			success: function(data){			
				var innerClipListArea = document.getElementById('innerClipList');
				clipList = JSON.parse(data);
				var str = "";
				
				for (i=0; i<clipList.length; i++){
					if (i%5==0) {
						str+="<div class='container'> <div class='row firstPage'>";
					}
					str += "<li> <div class='wrap_thumb thumbnail'>";
					str += "<a href='clipView.do?clipId=" + clipList[i].id + "' title='" + clipList[i].title + "'><img src='"+clipList[i].thumbUrl+"' width='187px' height='105px'></a>";
					str += "<div class='caption'> <p class='title'>" + clipList[i].title + "</p>";
					str += "<span class='img_sample num_txt'></span><p class='numOfPlay'>" + clipList[i].numOfPlay + "</p><p class='numOfLike'><i class='fa fa-thumbs-o-up'></i> "+ clipList[i].numOfLike +"</p></div></div></li>";
					if (i%5==4) {
						str+="</div> </div>";
					}
				}				
				innerClipListArea.innerHTML += str;
			},
			error: function(error){
				alert("더보기 할 수 없습니다." + error);
			}
		})
	});
});
//moreClips in clipView
$(document).ready(function(){
	var firstClipId = 0;

	$('#moreClipsInClipView').bind('click', function(){
		firstClipId += 21;

		$.ajax({
			type:"POST",
			url:"moreClipsInClipView.do",
			timeout: 1000,
			data: {
				"firstClipId":firstClipId
			},
			dataType:"text",
			success: function(data){			
				var innerClipListArea = document.getElementById('innerClipList');
				clipList = JSON.parse(data);
				var str = "";
				
				for (i=0; i<clipList.length; i++){
					if (i%3==0) {
						str+="<div class='row clipPage'>";
					}
					str += "<li> <div class='wrap_thumb thumbnail'>";
					str += "<a href='clipView.do?clipId=" + clipList[i].id + "' title='" + clipList[i].title + "'><img src='"+clipList[i].thumbUrl+"' width='187px' height='105px'></a>";
					str += "<div class='caption'> <p class='title'>" + clipList[i].title + "</p>";
					str += "<span class='img_sample num_txt'></span><p class='numOfPlay'>" + clipList[i].numOfPlay + "</p><p class='numOfLike'><i class='fa fa-thumbs-o-up'></i> "+ clipList[i].numOfLike +"</p></div></div></li>";
					if (i%3==2) {
						str+="</div>";
					}
				}				
				innerClipListArea.innerHTML += str;
			},
			error: function(error){
				alert("더보기 할 수 없습니다." + error);
			}
		})
	});
});
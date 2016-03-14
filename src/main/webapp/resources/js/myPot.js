$(document).ready(function(){
	$('#delAllClips').bind('click', function(){
		$.ajax({
			type: "POST",
			url: "delAllClips.do",
			timeout: 1000,
			success: function(data){
				alert("전체 삭제 하셨습니다.");
				location.reload();
			}
		});
	});
});
//history.back();
$(document).ready(function(){
      getAll();
	
	 $("#save").click(function(){
		var studentid = $("#studentId").val();
		var courseid = $("#courseId").val();
		
		if(studentid == "")
		{
		$("#studentId").focus().css("outline-color","#e53935");
		return;
		}
	if(courseid == "")
		{
		$("#courseId").focus().css("outline-color","#e53935");
		return;
		}
	
		var url="http://localhost:8080/studentregister/studentCourse?operation=add&sId="+studentid+"&courseId="+courseid;
		$("input[type=text],checkbox").val("");
		$.ajax({
			url: url,
			type: 'POST'
				
		})
		.done(function(result){
			alert(result);
		}).fail(function(result){
			alert(result);
		});
	});
});


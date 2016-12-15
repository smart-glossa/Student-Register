$(document).ready(function(){
	getAll();
	
	 $("#submit").click(function(){
		var studentid = $("#sId").val();
		var courseid = $("#couId").val();
		var date = $("#date").val();
		 var present = $("input[name='attandance']:checked").val();
		if(studentid == "")
		{
		$("#sId").focus().css("outline-color","#e53935");
		return;
		}
	if(courseid == "")
		{
		$("#couId").focus().css("outline-color","#e53935");
		return;
		}
	if(date == ""){
		$("#date").focus().css("outline-color","#e53935");
		return;
	}
	if(present == ""){
		$("#ab").focus().css("outline-color","#e53935");
		return;
	}
		var url="http://localhost:8080/studentregister/attendencs?operation=add&sId="+studentid+"&courseId="+courseid+"&date="+date+"&presents="+present;
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


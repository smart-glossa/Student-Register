
$(document).ready(function(){
	getAll();
	$(document).on('click','#subm',function(){
		var courseid = $("#courseId").val();
		var coursename = $("#crname").val();
		var duration = $("#duration").val();
		
	if( courseid == "")
	{
	$("#courseId").focus().css("outline-color","#e53935");
	return;
		}
	if(coursename == ""){
		$("#crName").focus().css("outline-color","#e53935");
		return;
	}
	if(duration == ""){
		$("#Duration").focus().css("outline-color","#e53935");
		return;
	}
		var url="http://localhost:8080/studentregister/course?operation=add&courseId="+courseid+"&name="+coursename +"&duration="+duration;
		$("input[type=text]").val("");
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


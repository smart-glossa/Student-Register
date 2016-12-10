$(document).ready(function(){
	getAll();
	
	 $("input[type='button']").click(function(){
		var attandenceid = $("#aId").val();
		var classid = $("#classId").val();
		var date = $("#date").val();
		   var attandence = $("input[name='attandance']:checked").val();
		if(attandenceid == "")
		{
		$("#aId").focus().css("outline-color","#e53935");
		return;
		}
	if(classid == "")
		{
		$("#classId").focus().css("outline-color","#e53935");
		return;
		}
	if(date == ""){
		$("#date").focus().css("outline-color","#e53935");
		return;
	}
	if(attandence == ""){
		$("#attan").focus().css("outline-color","#e53935");
		return;
	}
		var url="http://localhost:8080/studentregister/attendencs?operation=add&aId="+attandenceid+"&classId="+classid+"&date="+date+"&attendence="+attandence;
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



$(document).ready(function(){
	getAll();
	$(document).on('click','#subm',function(){
		var classid = $("#classId").val();
		var stuid = $("#stuId").val();
		var classname = $("#clname").val();
		var duration = $("#duration").val();
		if(classid== "")
		{
		$("#classId").focus().css("outline-color","#e53935");
		return;
		}
	if(stuid  == "")
		{
		$("#stuId").focus().css("outline-color","#e53935");
		return;
		}
	if(classname == ""){
		$("#className").focus().css("outline-color","#e53935");
		return;
	}
	if(duration == ""){
		$("#Duration").focus().css("outline-color","#e53935");
		return;
	}
		var url="http://localhost:8080/studentregister/student?operation=student&classId="+classid+"&sId="+stuid+"&className="+classname+"&Duration="+duration;
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


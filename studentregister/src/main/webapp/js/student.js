$(document).ready(function(){
	getAll();
	
	$(document).bind("click","#add",function(){
		var sId = $("#id").val();
		var studentName= $("#name").val();
		var address = $("#address").val();
		var contactNumber = $("#contactNumber").val();
		var Gender = $("#gender").val();
		var dob = $("#dob").val();
		var joindate = $("#join").val();
	
		if(sId == "")
			{
			$("#id").focus().css("outline-color","#e53935");
			return;
			}
		if(studentName == "")
			{
			$("#name").focus().css("outline-color","#e53935");
			return;
			}
		if(address == ""){
			$("#address").focus().css("outline-color","#e53935");
			return;
		}
		if(contactNumber == ""){
			$("#contactNumber").focus().css("outline-color","#e53935");
			return;
		}
		if(Gender == ""){
			$("#gender").focus().css("outline-color","#e53935");
			return;
		}
		if(dob == ""){
			$("#dob").focus().css("outline-color","#e53935");
			return;
		}
		if(joindate == ""){
			$("#join").focus().css("outline-color","#e53935");
			return;
		}
		
		var url="http://localhost:8080/studentregister/student?operation=register&sId="+sId+"&studentName="+studentName+"&Address="+address+"&contactNumber="+contactNumber+"&Gender="+Gender+"&DOB="+dob+"&joinDate="+joindate;
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
	$(document).on("keyup","#id",function(){
		var sId = $("#id").val();
		if(sId != ""){
			var url = "http://localhost:8080/studentregister/student?operation=getone&sId="+sId;
			$.ajax({
				url: url,
				type: 'POST'
			})
			.done(function(result){
				result= JSON.parse(result);
				$("#name").val(result.studentName);
				$("#address").val(result.Address);
				$("#contactNumber").val(result.contactNumber);
				$("#gender").val(result.Gender);
				$("#dob").val(result.DOB);
				$("#join").val(result.joinDate);
				
			});
		}
	});
			
			});



function getAll()
{
	var url = "http://localhost:8080/studentregister/student?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var div = "<div >"
		for (var i = 0; i < result.length; i++) {
			div += "<div class='fulldetail'>"
    		div += "<p id='na'>" + result[i].studentName + "</p>"
			div += "<p>" + result[i].Address + "</p>"
			div += "<p>" + result[i].contactNumber + "</p>"
			div += "<p>" + result[i].Gender + "</p>"
			div += "<p>" + result[i].DOB + "</p>"
			div += "<p>" + result[i].joinDate + "</p>"
			div += "</div>"

		}
		div += "</div>";
		$(".details")[0].innerHTML = div;
	});
}
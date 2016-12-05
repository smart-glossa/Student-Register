$(document).ready(function(){
	getAll();
	
	$(document).on('click','#submit',function(){
		var attandenceid = $("#aId").val();
		var classid = $("#classId").val();
		var date = $("#date").val();
		var attandence = $("#attan").val();
		var url="http://localhost:8080/studentregister/attandance?operation=add&aId="+attandenceid+"&classId="+classid+"&date="+date+"&attendence="+attandence;
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

function getAll()
{
	var url = "http://localhost:8080/studentregister/attandance?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var table = "<table border=1px solid black >"
		table += "<tr><th>AttandanceId</th><th>ClassId</th><th>Date</th><th>Present</th></tr>"
		for (var i = 0; i < result.length; i++) {
			table += "<tr>"
		    table += "<td>" + result[i].aId + "</td>"
            table += "<td>" + result[i].classId + "</td>"
			table += "<td>" + result[i].date + "</td>"
			table += "<td>" + result[i].attendence + "</td>"
			table += "</tr>"

		}
		table += "</table>";
		$(".attandance")[0].innerHTML = table;
	});
}
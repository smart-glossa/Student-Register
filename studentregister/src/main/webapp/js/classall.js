function getAll()
{
	var url = "http://localhost:8080/studentregister/student?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var table = "<table border=1px solid black >"
		table += "<tr><th>ClassId</th><th>StudentId</th><th>ClassNmae</th><th>Duration</th></tr>"
		for (var i = 0; i < result.length; i++) {
			table += "<tr>"
		    table += "<td>" + result[i].classId + "</td>"
            table += "<td>" + result[i].sId + "</td>"
			table += "<td>" + result[i].className + "</td>"
			table += "<td>" + result[i].Duration + "</td>"
			table += "</tr>"

		}
		table += "</table>";
		$(".classall")[0].innerHTML = table;
	});
}
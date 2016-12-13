function getAll()
{
	var url = "http://localhost:8080/studentregister/course?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var table = "<table border=1px solid black >"
		table += "<tr><th>CourseId</th><th>CourseName</th><th>Duration</th></tr>"
		for (var i = 0; i < result.length; i++) {
			table += "<tr>"
		    table += "<td>" + result[i].courseId + "</td>"
			table += "<td>" + result[i].name + "</td>"
			table += "<td>" + result[i].duration + "</td>"
			table += "</tr>"

		}
		table += "</table>";
		$(".courseall")[0].innerHTML = table;
	});
}
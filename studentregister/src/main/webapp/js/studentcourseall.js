function getAll()
{
	var url = "http://localhost:8080/studentregister/studentcourse?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var table = "<table border=1px solid black >"
		table += "<tr><th>StudentId</th><th>CourseId</th></tr>"
		for (var i = 0; i < result.length; i++) {
			table += "<tr>"
		    table += "<td>" + result[i].sId + "</td>"
            table += "<td>" + result[i].courseId + "</td>"
			table += "</tr>"

		}
		table += "</table>";
		$(".studentcourseall")[0].innerHTML = table;
	});
}
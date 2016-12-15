function getAll()
{
	var url = "http://localhost:8080/studentregister/attendencs?operation=getAll"
	$.ajax({
		url : url,
		type : 'POST'
	}).done(function(result) {
		var result = JSON.parse(result);
		var table = "<table border=1px solid black >"
		table += "<tr><th>StudentId</th><th>CourseId</th><th>Date</th><th>Present</th></tr>"
		for (var i = 0; i < result.length; i++) {
			table += "<tr>"
		    table += "<td>" + result[i].sId + "</td>"
            table += "<td>" + result[i].courseId + "</td>"
			table += "<td>" + result[i].date + "</td>"
			var Atten = result[i].presents;
			if(Atten==1){
				var aa = "Present";
			}else{
				var aa = "Absent";
			}
			table += "<td>" + aa + "</td>"
			table += "</tr>"

		}
		table += "</table>";
		$(".attandance")[0].innerHTML = table;
	});
}
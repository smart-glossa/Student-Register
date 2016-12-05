function getAll()
{
	var url = "http://localhost:8080/studentregister/students?operation=getAll"
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
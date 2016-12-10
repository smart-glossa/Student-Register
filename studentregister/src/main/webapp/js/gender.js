/**
 * 
 */
$(document).ready(function(){

	$(document).on('click','#subm',function(){
		
		var gender = $("#aa").val();

		var url="http://localhost:8080/studentregister/gender?operation=add&gender="+gender;
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


$(document).ready(function(){
         $("input[type='button']").click(function(){
             var radioValue = $("input[name='attandance']:checked").val();
           //http://localhost:8080/studentregister/gender?operation=add&gender=female
 	var url = "/studentregister/gender?operation=add&gender="+ radioValue ;
 	$.ajax({
 		url:url,
 		type:'POST'
 	})
 	.done(function(result){
 		alert(result);
 	})
 	.fail(function(result){
 	alert(result);
 	})
 	
 });
 }); 

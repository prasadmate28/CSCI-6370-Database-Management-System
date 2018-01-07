$(document).ready(function(){
	
$(".addResource").click(function()
{
	
   console.log('button clicked');
   var tr=$(this).parents('tr');
   var data={}
   data.resourceName=$(tr).find('td').eq(0).text();
   data.resourceDecription=$(tr).find('td').eq(4).text();
   data.resourcesToAdd=$(tr).find('select :selected').text();
   var resourcesToAdd=$(tr).find('select :selected').text();
   data.mgrId=$("#mgrId").val();
   console.log(data);
   
   $.ajax({
       type: "POST",
       contentType: "application/json",
       url: "/addResource",
       data: JSON.stringify(data),
       //dataType: 'json',
       cache: false,
       success: function (data) {
      
       	var data=JSON.parse(data);
       var currTot = $(tr).find('td').eq(1).text();
       var tot=Number(currTot)+Number(resourcesToAdd);
       $(tr).find('td').eq(1).text(tot);
       var inuse = $(tr).find('td').eq(2).text();
       $(tr).find('td').eq(3).text(tot-inuse); 
       
          

       }
       
   });

   /*$(tr).find('td').each (function() {
	 

	   
	   
	 }); */


});
	
	




});
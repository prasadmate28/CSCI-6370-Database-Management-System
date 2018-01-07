$(document).ready(function()
{
	
console.log('jquery loaded');

$("#requestService").click(function()
{
	var content={}
	var id=$("#userId").val();
	var deptId=$("#departmentId").val();
	var serviceId=$("#service option:selected").val();
	var serviceName=$("#service option:selected").text();
	var role=$("#role").val();
	content.id=id;
	content.deptId=deptId;
	content.serviceId=serviceId;
	content.role=role;
	console.log(serviceId);
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/requestService",
        data: JSON.stringify(content),
        //dataType: 'json',
        cache: false,
        success: function (data) {
       
        	var data=JSON.parse(data);
             if(data.status=='PENDING')
            	 {
            	    $("#pending").append('<li class="list-group-item"><span><img src="images/redDot.jpg" width="10" height="10"/></span> '+serviceName+' </li>')
            	    $("#reqSubmisssion").text(" ");
            	    $("#reqSubmisssion").append("Your request has been submitted. Request Id is  "+data.requestId);
            	    $("#reqModal").modal('show');
            	    
            	 }
           

        }
        
    })



});


$("#approveBulk").click(function()
{
	
	//$('#pendingRequestTable tr').has('.pendingApprovals:checked').remove()
	var data=[]
    $("#pendingRequestTable tr").each(function() {
    	var flag=false;
    	var content=new Object();
    	$(this).filter(':has(:checkbox:checked)').find('td').each(function() {
    	    // this = td element
    		flag=true;
    		
    	});
 if(flag){
	 content.requestId=$(this).find('td').eq(0).text();
		content.serviceId=$(this).find('td').eq(1).text()
		data.push(content)
	 }
});
	console.log(data);
	$.ajax({
	       type: "POST",
	       contentType: "application/json",
	       url: "/approveResources",
	       data: JSON.stringify(data),
	       //dataType: 'json',
	       cache: false,
	       success: function (data) {
	      
	       console.log('data has been approved') 
	       
	        $('#pendingRequestTable tr').has('.pendingApprovals:checked').remove()  

	       }
	       
	   });


});





















}		

		
)
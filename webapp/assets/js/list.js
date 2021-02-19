var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));

$(".listDelete").on("click", function(){
	var thisPos = $(this);
	var formData = {contentNo : Number($(this).parent().prev().prev().prev().text())}

	$.ajax({		
			url : url+"/delete",			
			type: "post",
           	contentType : "application/json",
			data : JSON.stringify(formData),
			dataType : "json",
			success : function(result){
				if(result == 1){
					thisPos.parent().parent().remove();
				} else{
					alert("삭제 실패");
				}		
			},	
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}	
		});
		
});
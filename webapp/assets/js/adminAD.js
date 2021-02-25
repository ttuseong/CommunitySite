var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));

$(".adInsertBtn").on("click", function(){	
	var form = $(".adForm");
	
	var formData = new FormData(form[0]);
	
	$.ajax({		
		url : url+"/admin/adInsert",			
		type: "post",
		enctype: 'multipart/form-data',
		processData:false,
       	contentType : false,
		data : formData,
		dataType : "json",
		success : function(result){
			addAd(result);
		},	
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}	
	}); 
});

function addAd(vo){
	var str = "";
	
	str += '<tr>';
	str += '<td>'+ vo.adNo + '</td>';
	str += '<td>' + vo.adTitle + '</td>';
	str += '<td>' + vo.adDesc + '</td>';
	str += '<td><img alt="" src="' + url + '/upload/' + vo.saveName + '"></td>';
	str += '<td>'+ vo.adEffect + '</td>';
	str += '<td><i class="fas fa-trash-alt deleteBtn"></i></td>';
	str += '</tr>';
	
	$("tbody").prepend(str);
}

$("tbody").on("click", ".deleteBtn", function(){
	var thisTarget = $(this);
	
	var formData = { adNo : thisTarget.parent().prev().prev().prev().prev().prev().text() }

	$.ajax({		
		url : url+"/admin/adDelete",			
		type: "post",
       	contentType : "application/json",
		data : JSON.stringify(formData),
		dataType : "json",
		success : function(result){
			if(result == 1){
				thisTarget.parent().parent().remove();
			} 	
		},	
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}	
	});
});
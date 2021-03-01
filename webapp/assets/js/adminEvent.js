var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));

var updateTr;

$(".eventInsertBtn").on("click", function(){	
	var form = $(".eventForm");
	
	var formData = new FormData(form[0]);
	
	if($("input[name=eventNo]").val() == ""){
		$.ajax({		
			url : url+"/admin/eventInsert",			
			type: "post",
			enctype: 'multipart/form-data',
			processData:false,
	       	contentType : false,
			data : formData,
			dataType : "json",
			success : function(result){
				addEvent(result);
			},	
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}	
		}); 
	} else{
		$.ajax({		
			url : url+"/admin/eventUpdate",			
			type: "post",
			enctype: 'multipart/form-data',
			processData:false,
	       	contentType : false,
			data : formData,
			dataType : "json",
			success : function(result){
				updateEvent(result);
			},	
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}	
		}); 
	}
	
	
});

function addEvent(vo){
	var str = "";
	
	str += '<tr>';
	str += '	<td>'+ vo.eventNo +'</td>';
	str += '	<td>'+ vo.eventName +'</td>';
	str += '	<td>'+ vo.eventLink +'</td>';
	str += '	<td><img alt="" src="' + url+'/upload/' + vo.saveName + '"></td>';
	str += '	<td><i class="fas fa-trash-alt deleteBtn"></i></td>';
	str += '</tr>';
	
	$("tbody").prepend(str);	
	
}

function updateEvent(vo){
	updateTr.children().eq(1).text(vo.eventName);
	updateTr.children().eq(2).text(vo.eventLink);
	if(vo.saveName != undefined){
		updateTr.children().eq(3).children().eq(0).attr("src", url+"/upload/"+vo.saveName);
	}
}

$("tbody").on("click", "td", function(){
	if(!$(this).children().eq(0).hasClass("deleteBtn")){
		updateTr = $(this).parent();

		$("input[name=eventNo]").val(updateTr.children().eq(0).text());
		$("input[name=eventName]").val(updateTr.children().eq(1).text());
		$("input[name=eventLink]").val(updateTr.children().eq(2).text());
	}
})

$("tbody").on("click", ".deleteBtn", function(){
	var thisTarget = $(this);
	
	var formData = { eventNo : $(this).parent().prev().prev().prev().prev().text() }
	
	$.ajax({		
		url : url+"/admin/eventDelete",			
		type: "delete",
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
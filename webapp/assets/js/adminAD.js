var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));
var updateTr;

$(".adInsertBtn").on("click", function(){	
	var form = $(".adForm");
	
	var formData = new FormData(form[0]);
	
	if($("input[name=adNo]").val() == ""){
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
	} else{
		$.ajax({		
			url : url+"/admin/adUpdate",			
			type: "post",
			enctype: 'multipart/form-data',
			processData:false,
	       	contentType : false,
			data : formData,
			dataType : "json",
			success : function(result){
				update(result);
			},	
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}	
		}); 
	}
	
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

function update(vo){
	updateTr.children().eq(1).text(vo.adTitle);
	updateTr.children().eq(2).text(vo.adDesc);
	if(vo.saveName != undefined){
		updateTr.children().eq(3).children().eq(0).attr("src", url+"/upload/"+vo.saveName);
	}
	updateTr.children().eq(4).text(vo.adEffect);
}

$("tbody").on("click", "td", function(){
	if(!$(this).children().eq(0).hasClass("deleteBtn")){
		updateTr = $(this).parent();

		$("input[name=adNo]").val(updateTr.children().eq(0).text());
		$("input[name=adTitle]").val(updateTr.children().eq(1).text());
		$("input[name=adDesc]").val(updateTr.children().eq(2).text());
		
		if(updateTr.children().eq(4).text() == "0"){
			$("input:radio[name=adEffect]:input[value=0]").attr("checked", true);
			
		} else if(updateTr.children().eq(4).text() == "1"){
			$("input:radio[name=adEffect]:input[value=1]").attr("checked", true);
		}

	}
})

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
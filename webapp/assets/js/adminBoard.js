var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));

$(".boardInsertBtn").on("click", function(){
	console.log($("input[name=boardName]").val());
	var formData = {boardName : $("input[name=boardName]").val(), boardType : Number($("input[name=boardType]:checked").val())}

	$.ajax({		
		url : url+"/admin/boardInsert",			
		type: "post",
       	contentType : "application/json",
		data : JSON.stringify(formData),
		dataType : "json",
		success : function(result){
			addBoardList(result);	
		},	
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}	
	});
});

function addBoardList(vo){
	var str = "";
	str += '<tr>';
	str += '	<td>' + vo.boardNo + '</td>';
	str += '	<td>' + vo.boardName + '</td>';
	if(vo.boardType == 0){
		str += '	<td>' + "직업 게시판" + '</td>';
	} else{
		str += '	<td>' + "커뮤니티 게시판" + '</td>';
	}
	
	str += '	<td><i class="fas fa-trash-alt deleteBtn"></i></td>';
	str += '</tr>';	    	
	
	$("tbody").prepend(str);			
}

$("tbody").on("click", ".deleteBtn", function(){
	var thisTarget = $(this);
	var formData = { boardNo : $(this).parent().prev().prev().prev().text() }
	
	$.ajax({		
		url : url+"/admin/boardDelete",			
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
})
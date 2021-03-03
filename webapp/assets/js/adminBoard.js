var url = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));

var updateTr;

$(".boardInsertBtn").on("click", function(){

	if($("input[name=boardNo]").val() == ""){
		var formData = {boardName : $("input[name=boardName]").val(), boardType : Number($("input[name=boardType]:checked").val())}
		
		$.ajax({		
			url : url+"/admin/board",			
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
	} else{
		var formData = {boardName : $("input[name=boardName]").val(), 
		boardType : Number($("input[name=boardType]:checked").val()),
		boardNo : Number($("input[name=boardNo]").val())}
		
		$.ajax({		
			url : url+"/admin/board",			
			type: "put",
	       	contentType : "application/json",
			data : JSON.stringify(formData),
			dataType : "json",
			success : function(result){
				updateBoard(result);	
			},	
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}	
		});
	}
	
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

function updateBoard(vo){
	updateTr.children().eq(1).text(vo.boardName);
	
	if(vo.boardType == 0){
		updateTr.children().eq(2).text("직업 게시판");
	} else{
		updateTr.children().eq(2).text("커뮤니티 게시판");
	}
}

$("tbody").on("click", "td", function(){
	if(!$(this).children().eq(0).hasClass("deleteBtn")){
		updateTr = $(this).parent();

		$("input[name=boardNo]").val(updateTr.children().eq(0).text());
		$("input[name=boardName]").val(updateTr.children().eq(1).text());
		
		if(updateTr.children().eq(2).text() == "직업 게시판"){
			$("input:radio[name=boardType]:input[value=0]").attr("checked", true);
			
		} else if(updateTr.children().eq(2).text() == "커뮤니티 게시판"){
			$("input:radio[name=boardType]:input[value=1]").attr("checked", true);
		}

	}
})

$("tbody").on("click", ".deleteBtn", function(){
	var thisTarget = $(this);
	var formData = { boardNo : $(this).parent().prev().prev().prev().text() }
	
	$.ajax({		
		url : url+"/admin/board",			
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
})
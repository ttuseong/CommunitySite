<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>layout1</title>

    <!-- style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/adminBoard.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script></script>
    <script src="https://kit.fontawesome.com/ff5ee53d46.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>

    <!-- 웹폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">

  </head>
  <body>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    
    <section class="contents">
    	<div class="container">
    		<jsp:include page="/WEB-INF/views/include/adminLeftSide.jsp" />
    		
    		<section id="cont-center">
    			<h2>게시판 관리</h2>
    			<section>
	    			<form>
	    				<h3>게시판 추가 및 변경</h3>
	    				<div class="conterContents">
	    					<input class="hiddenClass" type="text" name="boardNo">
	    					<input type="text" placeholder="게시판 이름을 입력해주세요" name="boardName">
		    				<span>직업 게시판</span>    <input type="radio" name="boardType" value="0">
		    				<span>커뮤니티 게시판</span> <input type="radio" name="boardType" value="1">
		    				<button class="boardInsertBtn" type="button">확인</button>
	    				</div>
	    			</form>
    			</section>
    			<section>
    				<h3>게시판 목록</h3>
    				<div class="conterContents">
    					<table>
	    					<thead>
	    						<tr>
	    							<th>no</th>
	    							<th>게시판 이름</th>
	    							<th>게시판 종류</th>
	    							<th>삭제</th>
	    						</tr>
	    					</thead>
	    					<tbody>
	    						<c:forEach items="${boardContents.boardList }" var="boardVo">
	    							<tr>
		    							<td>${boardVo.boardNo }</td>
		    							<td>${boardVo.boardName }</td>
		    							<c:if test="${boardVo.boardType == 0 }">
		    								<td>직업 게시판</td>
		    							</c:if>
		    							<c:if test="${boardVo.boardType != 0 }">
		    								<td>커뮤니티 게시판</td>
		    							</c:if>
		    							<td><i class="fas fa-trash-alt deleteBtn"></i></td>
		    						</tr>
	    						</c:forEach>
	    					</tbody>
	    				</table>
	    				<ul class="pageList">
	    					<c:if test="${boardContents.cntPage != 1 && boardContents.page != 0 }">
								<li><a href="${pageContext.request.contextPath}/admin/board?boardPage=${boardContents.cntPage-1}">◀</a></li>
							</c:if>
	    					<c:forEach var="count" begin="1" end="${boardContents.page }" step="1">
	    						<li><a href="${pageContext.request.contextPath}/admin/board?boardPage=${count}">${count }</a></li>
	    					</c:forEach>
	    					<c:if test="${boardContents.cntPage != boardContents.page && boardContents.page != 0 }">
								<li><a href="${pageContext.request.contextPath}/admin/board?boardPage=${boardContents.cntPage+1}">▶</a></li>
							</c:if>
	    				</ul>
    				</div>
    			</section>
    		</section>
    	</div>
    </section>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/adminBoard.js"></script>
</html>
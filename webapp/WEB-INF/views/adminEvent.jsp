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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/adminEvent.css">

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
    			<h2>이벤트 관리</h2>
    			<section>
	    			<form class="eventForm" enctype="multipart/form-data">
	    				<h3>이벤트 추가</h3>
	    				<div class="conterContents">
	    					<input type="text" placeholder="이벤트 이름을 입력해주세요" name="eventName">
		    				<input type="text" placeholder="이벤트 링크를 입력해주세요" name="eventLink">
		    				<input type="file" name="eventImg">
		    				<button class="eventInsertBtn" type="button">확인</button>
	    				</div>
	    			</form>
    			</section>
    			<section>
    				<h3>이벤트 목록</h3>
    				<div class="conterContents">
    					<table>
	    					<thead>
	    						<tr>
	    							<th>no</th>
	    							<th>이벤트 이름</th>
	    							<th>이벤트 주소</th>
	    							<th>이벤트 이미지</th>
	    							<th>삭제</th>
	    						</tr>
	    					</thead>
	    					<tbody>
	    						<c:forEach items="${eventList }" var="listVo">
	    							<tr>
		    							<td>${listVo.eventNo}</td>
		    							<td>${listVo.eventName }</td>
		    							<td>${listVo.eventLink }</td>
		    							<td><img alt="" src="${pageContext.request.contextPath}/upload/${listVo.eventImg}"></td>
		    							<td><i class="fas fa-trash-alt deleteBtn"></i></td>
		    						</tr>
	    						</c:forEach>
	    					</tbody>
	    				</table>
    				</div>
    			</section>
    		</section>
    	</div>
    </section>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/adminEvent.js"></script>
</html>
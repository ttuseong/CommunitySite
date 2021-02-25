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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/adminAd.css">

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
    			<h2>광고 관리</h2>
    			<section>
	    			<form class="adForm">
	    				<h3>광고 추가</h3>
	    				<div class="conterContents">
	    					<input type="text" placeholder="광고 이름을 입력해주세요" name="adTitle">
		    				<input type="text" placeholder="광고 내용을 입력해주세요" name="adDesc">
		    				<input type="file" name="adImg">
		    				<span>효과 1</span> <input type="radio" name="adEffect" value="0">
		    				<span>효과 2</span> <input type="radio" name="adEffect" value="1">
		    				<button type="button" class="adInsertBtn">확인</button>
	    				</div>
	    			</form>
    			</section>
    			<section>
    				<h3>광고 목록</h3>
    				<div class="conterContents">
    					<table>
	    					<thead>
	    						<tr>
	    							<th>no</th>
	    							<th>광고 이름</th>
	    							<th>광고 내용</th>
	    							<th>광고 이미지</th>
	    							<th>광고 효과</th>
	    							<th>삭제</th>
	    						</tr>
	    					</thead>
	    					<tbody>
	    						<c:forEach items="${adList }" var="vo">
	    							<tr>
		    							<td>${vo.adNo }</td>
		    							<td>${vo.adTitle }</td>
		    							<td>${vo.adDesc }</td>
		    							<td><img alt="" src="${pageContext.request.contextPath}/upload/${vo.adImg}"></td>
		    							<td>${vo.adEffect}</td>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/adminAD.js"></script>
</html>
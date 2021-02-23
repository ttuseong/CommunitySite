<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    		<section id="cont-left">
    			<ul class="adminMenu">
    				<li><a>게시판 관리 <i class="fas fa-angle-double-right"></i></a></li>
    				<li><a>이벤트 관리 <i class="fas fa-angle-double-right"></i></a></li>
    				<li><a>광고 관리 <i class="fas fa-angle-double-right"></i></a></li>
    			</ul>
    		</section>
    		
    		<section id="cont-center">
    			<h2>게시판 관리</h2>
    			<section>
	    			<form action="">
	    				<h3>게시판 추가</h3>
	    				<div class="conterContents">
	    					<input type="text" placeholder="게시판 이름을 입력해주세요" name="boardName">
		    				<span>직업 게시판</span> </a><input type="radio" name="boardType">
		    				<span>커뮤니티 게시판</span> <input type="radio" name="boardType">
		    				<button type="submit">확인</button>
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
	    						<tr>
	    							<td>1</td>
	    							<td>바드</td>
	    							<td>직업 게시판</td>
	    							<td><i class="fas fa-trash-alt"></i></td>
	    						</tr>
	    						<tr>
	    							<td>1</td>
	    							<td>바드</td>
	    							<td>직업 게시판</td>
	    							<td><i class="fas fa-trash-alt"></i></td>
	    						</tr>
	    						<tr>
	    							<td>1</td>
	    							<td>바드</td>
	    							<td>직업 게시판</td>
	    							<td><i class="fas fa-trash-alt"></i></td>
	    						</tr>
	    					</tbody>
	    				</table>
    				</div>
    			</section>
    		</section>
    	</div>
    </section>

</body>
</html>
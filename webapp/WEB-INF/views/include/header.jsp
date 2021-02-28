<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal.css">
<header id="header">
	<div class="container">
		<div class="row">
			<div class="title">
				<a href="${pageContext.request.contextPath}/"><p>로스트 아크 커뮤니티</p></a>
				<!-- <h1><a href="#">깃허브</a></h1> -->
			</div>
			<!-- title -->
			<div class="icon-font">
				<ul>
					<li><a href="#"> <i class="fab fa-github"></i> <span
							class="tool">github</span>
					</a></li>
					<li><a href="#"> <i class="fab fa-instagram"></i> <span
							class="tool">instagram</span>
					</a></li>
					<li><a href="#"> <i class="fab fa-facebook-square"></i> <span
							class="tool">facebook</span>
					</a></li>
					<li><a href="#"> <i class="far fa-envelope"></i> <span
							class="tool">email</span>
					</a></li>
				</ul>
				<!-- icon-font -->
			</div>
			
			<c:if test="${empty authUser }">
				<div class="userForm">
	            	<button data-id="loginForm" class="login modalOpen" type="button" name="button">로그인</button>
	            	<button data-id="logregForm" class="login modalOpen" type="button" name="button">회원가입</button>
	          	</div>
			</c:if>
			
		  	<c:if test="${authUser == 1 }">
		  		<div class="userForm">
	            	<a class="manage" href="${pageContext.request.contextPath}/admin/board">관리</a>
	            	<a class="logout" href="${pageContext.request.contextPath}/logout">로그아웃</a>
	          	</div>
		  	</c:if>
          
		</div>
		<!-- row -->
	</div>
	<!-- container -->
	
	<div class="modal" id="loginForm">
	<div class="modal_cancell_ground">
	</div>
        <div class="modal_background">
            <div class="modal_size">
           		<div class="modal_text">로그인</div>
            	<form class="loginContent" action="${pageContext.request.contextPath}/login" method="post">
                  <input class="loginFormInput" placeholder="관리자 계정" type="text" name="managerID">
                  <input class="loginFormInput" placeholder="비밀번호" type="password" name="managerPW">
                  <button class="loginFormButton" type="submit" name="button">확인</button>
                  <button class="loginFormButton modalClose" type="button" name="button">취소</button>
                </form>
          	</div>
        </div>
	</div>
	
	<div class="modal" id="logregForm">
	<div class="modal_cancell_ground">
	</div>
        <div class="modal_background">
            <div class="modal_size">
            	<div class="modal_text">회원가입</div>
            	<form class="loginContent" action="${pageContext.request.contextPath}/logreg" method="post">
                  <input class="loginFormInput" placeholder="관리자 계정" type="text" name="managerID">
                  <input class="loginFormInput" placeholder="비밀번호" type="password" name="managerPW">
                  <button class="loginFormButton" type="submit" name="button">확인</button>
                  <button class="loginFormButton modalClose" type="button" name="button">취소</button>
                </form>
          	</div>
        </div>
	</div>
</header>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/modal.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="cont-right">
	<h3 class="ir">cont-right</h3>
	<article class="cbox column7">
		<h4 class="cbox-title">${cookie.count.value }</h4>
		<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
		<figure class="img1 rotate">
			<a href="#">
				<div class="front">
					<img src="${pageContext.request.contextPath}/assets/img/img1.jpg"
						alt="">
				</div>
				<div class="back">
					<figcaption>
						<i class="fas fa-heart fa-5x"></i>이미지에 대한 설명
					</figcaption>
				</div>
			</a>

		</figure>
		<!-- img1  -->
	</article>
	<!-- column7 -->
	<article class="cbox column8">
		<h4 class="cbox-title">광고 2</h4>
		<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>

		<figure class="img2 rotate2">
			<img src="${pageContext.request.contextPath}/assets/img/img1.jpg"
				alt="">
		</figure>
		<!-- img2 -->
	</article>
	<!-- column8 -->
</section>
<!-- cont-right -->
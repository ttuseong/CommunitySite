<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="cont-right">
	<h3 class="ir">cont-right</h3>
	<c:forEach items="${menu.adContent }" var="adVo">
		<c:if test="${adVo.adEffect == 0 }">
			<article class="cbox column7">
				<h4 class="cbox-title">${adVo.adTitle }</h4>
				<p class="cbox-desc">${adVo.adDesc }</p>
				<figure class="img1 rotate">
					<a href="#">
						<div class="front">
							<img src="${pageContext.request.contextPath}/upload/${adVo.adImg}"
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
		</c:if>
		<c:if test="${adVo.adEffect == 1 }">
			<article class="cbox column8">
				<h4 class="cbox-title">${adVo.adTitle }</h4>
				<p class="cbox-desc">${adVo.adDesc }</p>
		
				<figure class="img2 rotate2">
					<img src="${pageContext.request.contextPath}/upload/${adVo.adImg}"
						alt="">
				</figure>
				<!-- img2 -->
			</article>
			<!-- column8 -->
		</c:if>
	</c:forEach>
	
	
	
</section>
<!-- cont-right -->
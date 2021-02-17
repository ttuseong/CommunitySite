<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="cont-left">
	<h3 class="ir">cont-left</h3>
	<article class="cbox column1">
		<h4 class="cbox-title">직업 게시판</h4>
		<p class="cbox-desc">직업별 정보 공유</p>
		<div class="menu">
			<ul>
				<c:forEach items="${menu.menuList}" var="vo">
					<c:if test="${vo.boardType == 0 }">
						<li><a href="${pageContext.request.contextPath}/list?boardNo=${vo.boardNo}">${vo.boardName}<i
								class="fas fa-angle-double-right"></i></a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<!--menu-->
	</article>
	<!-- column1 -->
	<article class="cbox column2">
		<h4 class="cbox-title">커뮤니티 게시판</h4>
		<p class="cbox-desc">자유로운 소통 공간</p>

		<c:forEach items="${menu.menuList }" var="vo">
			<c:if test="${vo.boardType == 1 }">
				<div class="notice">
					<h5>${vo.boardName }</h5>
					<ul>
						<c:forEach items="${menu.contentmenu }" var="menuVo">
							<c:if test="${menuVo.key == vo.boardNo }">
								<c:forEach items="${menuVo.value }" var="content">
									<li><a href="${pageContext.request.contextPath}/read?contentNo=${content.contentNo}">${content.boardTitle }</a></li>
								</c:forEach>
							</c:if>
						</c:forEach>
					</ul>
					<span class="more"><a href="${pageContext.request.contextPath}/list?boardNo=${vo.boardNo}">more <i
							class="fas fa-arrow-alt-circle-right"></i></a></span>
				</div>
				<!-- notice  -->
			</c:if>
		</c:forEach>

	</article>
	<!-- column2 -->
	<article class="cbox column3">
		<h4 class="cbox-title">관련 사이트</h4>
		<p class="cbox-desc">관련 사이트 링크입니다</p>

		<div class="blog">
			<h5>Figure</h5>
			<figure>
				<a href="http://lostark.inven.co.kr/" class="blog-img"> <img
					src="${pageContext.request.contextPath}/assets/img/inven.png"
					alt=""> <em>Inven</em>
				</a>
			</figure>

		</div>
		<!-- Blog -->

		<div class="blog2">
			<h5>Figure</h5>
			<figure>
				<a href="https://lostark.game.onstove.com/Main" class="blog-img">
					<img
					src="${pageContext.request.contextPath}/assets/img/lostark.jpg"
					alt=""> <em>lost ark</em>
				</a>
			</figure>

		</div>
		<!-- Blog2 -->
	</article>
	<!-- column3 -->
</section>
<!-- cont-left -->
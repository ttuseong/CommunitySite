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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/lightgallery.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.transitions.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/list.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</script>
<script src="https://kit.fontawesome.com/ff5ee53d46.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>

<!-- 웹폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<section id="contents">
		<h2 class="ir">반응형 사이트 컨텐츠</h2>
		<div class="container">
			<jsp:include page="/WEB-INF/views/include/leftSide.jsp" />

			<section id="cont-center">
				<h3 class="ir">cont-center</h3>
				<article class="cbox column4">
					<h4 class="cbox-title">Gallery</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<div id="board">
						<div id="list">
							<form action="" method="">
								<div class="form-group text-right">
									<input type="text">
									<button type="submit" id=btn_search>검색</button>
								</div>
							</form>
							<table>
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성일</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listMap.list }" var="listVo">
										<tr>
											<td>${listVo.contentNo }</td>
											<td class="text-left"><a href="${pageContext.request.contextPath}/read?contentNo=${listVo.contentNo}">${listVo.boardTitle}</a></td>
											<td>${listVo.boardTime}</td>
											<td><a class="listDelete">[삭제]</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div id="paging">
								<ul>
									<c:if test="${listMap.cntPage != 1 && listMap.page != 0 }">
										<li><a href="${pageContext.request.contextPath}/list?boardNo=${listMap.boardNo}&cntPage=${listMap.cntPage-1}">◀</a></li>
									</c:if>
									<c:forEach var="count" begin="1" end="${listMap.page }" step="1">
										<c:if test="${count == listMap.cntPage }">
											<li class="active"><a href="${pageContext.request.contextPath}/list?boardNo=${listMap.boardNo}&cntPage=${count}">${count }</a></li>
										</c:if>
										<c:if test="${count != listMap.cntPage }">
											<li><a href="${pageContext.request.contextPath}/list?boardNo=${listMap.boardNo}&cntPage=${count}">${count }</a></li>
										</c:if>
										
									</c:forEach>
									<c:if test="${listMap.cntPage != listMap.page && listMap.page != 0 }">
										<li><a href="${pageContext.request.contextPath}/list?boardNo=${listMap.boardNo}&cntPage=${listMap.cntPage+1}">▶</a></li>
									</c:if>
								</ul>


								<div class="clear"></div>
							</div>
							<a id="btn_write" href="${pageContext.request.contextPath}/writeForm?boardNo=${listMap.boardNo}">글쓰기</a>

						</div>
						<!-- //list -->
					</div>
					<!-- Gallery -->
				</article>
				<!-- column4 -->
			</section>
			<!-- cont-center -->

			<jsp:include page="/WEB-INF/views/include/rightSide.jsp" />
		</div>
	</section>

	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/list.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/lightgallery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
</script>

</html>

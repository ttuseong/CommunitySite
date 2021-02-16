<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
										<th>글쓴이</th>
										<th>조회수</th>
										<th>작성일</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>123</td>
										<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
										<td>정우성</td>
										<td>1232</td>
										<td>2020-12-23</td>
										<td><a href="">[삭제]</a></td>
									</tr>
									<tr>
										<td>123</td>
										<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
										<td>정우성</td>
										<td>1232</td>
										<td>2020-12-23</td>
										<td><a href="">[삭제]</a></td>
									</tr>
									<tr>
										<td>123</td>
										<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
										<td>정우성</td>
										<td>1232</td>
										<td>2020-12-23</td>
										<td><a href="">[삭제]</a></td>
									</tr>
									<tr>
										<td>123</td>
										<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
										<td>정우성</td>
										<td>1232</td>
										<td>2020-12-23</td>
										<td><a href="">[삭제]</a></td>
									</tr>
									<tr class="last">
										<td>123</td>
										<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
										<td>정우성</td>
										<td>1232</td>
										<td>2020-12-23</td>
										<td><a href="">[삭제]</a></td>
									</tr>
								</tbody>
							</table>

							<div id="paging">
								<ul>
									<li><a href="">◀</a></li>
									<li><a href="">1</a></li>
									<li><a href="">2</a></li>
									<li><a href="">3</a></li>
									<li><a href="">4</a></li>
									<li class="active"><a href="">5</a></li>
									<li><a href="">6</a></li>
									<li><a href="">7</a></li>
									<li><a href="">8</a></li>
									<li><a href="">9</a></li>
									<li><a href="">10</a></li>
									<li><a href="">▶</a></li>
								</ul>


								<div class="clear"></div>
							</div>
							<a id="btn_write" href="${pageContext.request.contextPath}/write">글쓰기</a>

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

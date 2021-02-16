<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>layout1</title>

<!-- style -->
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/owl.carousel.css">
<link rel="stylesheet" href="assets/css/lightgallery.min.css">
<link rel="stylesheet" href="assets/css/owl.theme.css">
<link rel="stylesheet" href="assets/css/owl.transitions.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/write.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</script>
<script src="https://kit.fontawesome.com/ff5ee53d46.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>

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
						<div id="writeForm">
							<form action="#" method="get">
								<!-- 제목 -->
								<div class="form-group">
									<label class="form-text" for="txt-title">제목</label> <input
										type="text" id="txt-title" name="" value=""
										placeholder="제목을 입력해 주세요">
								</div>

								<!-- 내용 -->
								<div class="form-group">
									<textarea id="txt-content"></textarea>
								</div>

								<a id="btn_cancel" href="">취소</a>
								<button id="btn_add" type="submit">등록</button>

							</form>
							<!-- //form -->
						</div>
						<!-- //writeForm -->
					</div>
					<!-- //board -->
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
<script type="text/javascript" src="assets/js/custom.js"></script>
<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="assets/js/lightgallery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
</script>

</html>

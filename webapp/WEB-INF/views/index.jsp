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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lightgallery.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.transitions.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</script>
<script src="https://kit.fontawesome.com/ff5ee53d46.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>

<!-- 웹폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">

</head>
<body>
	<header id="header">
		<div class="container">
			<div class="row">
				<div class="quick">
					<a href="#">Designer Cafe</a> <a href="#">Developer Cafe</a>
				</div>
				<!-- quick -->
				<div class="title">
					<p>Professional Web Developer</p>
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
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</header>

	<section id="contents">
		<h2 class="ir">반응형 사이트 컨텐츠</h2>
		<div class="container">
			<section id="cont-left">
				<h3 class="ir">cont-left</h3>
				<article class="cbox column1">
					<h4 class="cbox-title">MENU</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<div class="menu">
						<ul>
							<li><a href="#">Cafe<i class="fas fa-angle-double-right"></i></a></li>
							<li><a href="#">Standard<i
									class="fas fa-angle-double-right"></i></a></li>
							<li><a href="#">Tutorial<i
									class="fas fa-angle-double-right"></i></a></li>
							<li><a href="#">Reference<i
									class="fas fa-angle-double-right"></i></a></li>
							<li><a href="#">CSS3<i class="fas fa-angle-double-right"></i></a></li>
							<li><a href="#">HYML5<i
									class="fas fa-angle-double-right"></i></a></li>
						</ul>
					</div>
					<!--menu-->
				</article>
				<!-- column1 -->
				<article class="cbox column2">
					<h4 class="cbox-title">Notice</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>

					<div class="notice">
						<h5>Graphic Design</h5>
						<ul>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
						</ul>
						<span class="more"><a href="#">more <i
								class="fas fa-arrow-alt-circle-right"></i></a></span>
					</div>
					<!-- notice  -->

					<div class="notice">
						<h5>Graphic Design</h5>
						<ul>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
							<li><a href="#">백엔드와 관련된 정보 공유 및 교육 정보 공유</a></li>
						</ul>
						<span class="more"><a href="#">more <i
								class="fas fa-arrow-alt-circle-right"></i></a></span>
					</div>
					<!-- notice  -->
				</article>
				<!-- column2 -->
				<article class="cbox column3">
					<h4 class="cbox-title">Blog</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>

					<div class="blog">
						<h5>Figure</h5>
						<figure>
							<a href="#" class="blog-img"> <img src="assets/img/img1.jpg"
								alt=""> <em>Blog</em>
							</a>

							<figcaption>웹 퍼블리싱과 관련된 정보 공유 및 교육을 위한 사이트입니다. 웹
								퍼블리싱과 관련</figcaption>
						</figure>

					</div>
					<!-- Blog -->

					<div class="blog2">
						<h5>Figure</h5>
						<figure>
							<a href="#" class="blog-img"> <img src="assets/img/img2.jpg"
								alt=""> <em>Blog</em>
							</a>

							<figcaption>웹 퍼블리싱과 관련된 정보 공유 및 교육을 위한 사이트입니다. 웹
								퍼블리싱과 관련</figcaption>
						</figure>

					</div>
					<!-- Blog2 -->
				</article>
				<!-- column3 -->
			</section>
			<!-- cont-left -->

			<section id="cont-center">
				<h3 class="ir">cont-center</h3>
				<article class="cbox column4">
					<h4 class="cbox-title">Gallery</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<div class="gallery ">
						<div id="owl-demo" class="owl-carousel owl-theme">
							<div class="item">
								<img src="assets/img/img1.jpg" alt="The Last of us">
							</div>
							<div class="item">
								<img src="assets/img/img2.jpg" alt="GTA V">
							</div>
						</div>
					</div>
					<!-- Gallery -->
				</article>
				<!-- column4 -->
				<article class="cbox column5">
					<h4 class="cbox-title">Square</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<div class="square clearfix" id="lightgallery">
						<a href="assets/img/img1.jpg"><img src="assets/img/img1.jpg"
							alt=""></a> <a href="assets/img/img2.jpg"><img
							src="assets/img/img2.jpg" alt=""></a> <a
							href="assets/img/img3.jpg"><img src="assets/img/img3.jpg"
							alt=""></a> <a href="assets/img/img4.jpg"><img
							src="assets/img/img4.jpg" alt=""></a> <a
							href="assets/img/img2.jpg"><img src="assets/img/img2.jpg"
							alt=""></a> <a href="assets/img/img1.jpg"><img
							src="assets/img/img1.jpg" alt=""></a> <a
							href="assets/img/img2.jpg"><img src="assets/img/img2.jpg"
							alt=""></a> <a href="assets/img/img3.jpg"><img
							src="assets/img/img3.jpg" alt=""></a> <a
							href="assets/img/img4.jpg"><img src="assets/img/img4.jpg"
							alt=""></a> <a href="assets/img/img2.jpg"><img
							src="assets/img/img2.jpg" alt=""></a>
					</div>

					<!-- Square -->
				</article>
				<!-- column5 -->
				<article class="cbox column6">
					<h4 class="cbox-title">Video</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<div class="video">
						<!-- <video controls="controls" autoplay="autoplay" loop="loop">
                <source src="assets/video/video.mp4" type="video/mp4">
              </video> -->
						<div class="video-container">
							<iframe class="iframe"
								src="https://www.youtube.com/embed/8kuNnuMYsFA"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
						</div>
					</div>
					<!-- video -->
				</article>
				<!-- column6 -->
			</section>
			<!-- cont-center -->

			<section id="cont-right">
				<h3 class="ir">cont-right</h3>
				<article class="cbox column7">
					<h4 class="cbox-title">Rotate</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>
					<figure class="img1 rotate">
						<a href="#">
							<div class="front">
								<img src="assets/img/img1.jpg" alt="">
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
					<h4 class="cbox-title">Title</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>

					<figure class="img2 rotate2">
						<img src="assets/img/img1.jpg" alt="">
					</figure>
					<!-- img2 -->
				</article>
				<!-- column8 -->
				<article class="cbox column9">
					<h4 class="cbox-title">Title</h4>
					<p class="cbox-desc">웹 백엔드와 관련된 정보 공유</p>

					<figure class="img3">
						<img src="assets/img/img1.jpg" alt="">
					</figure>
					<!-- img3  -->
				</article>
				<!-- column9 -->
			</section>
			<!-- cont-right -->
		</div>
	</section>

	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="footer">
					<ul>
						<li><a href="#">사이트 도움말</a></li>
						<li><a href="#">사이트 이용약관</a></li>
						<li><a href="#">사이트 운영원칙</a></li>
						<li><a href="#"><strong>개인정보취급방침</strong></a></li>
						<li><a href="#">책임의 한계와 법적고지</a></li>
						<li><a href="#">게시중단요청서비스</a></li>
						<li><a href="#">고객센터</a></li>
					</ul>
					<address class="">
						<em>Copyright &copy; <a href="#"><strong>webstoryboy</strong></a>
							All Rights Reserved.
						</em>
					</address>
				</div>
			</div>
		</div>
	</footer>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lightgallery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
</script>

</html>

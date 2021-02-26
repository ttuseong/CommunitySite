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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lightgallery.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.transitions.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
	

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script></script>
    <script src="https://kit.fontawesome.com/ff5ee53d46.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>

    <!-- 웹폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap" rel="stylesheet">

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
            <h4 class="cbox-title">이벤트</h4>
            <p class="cbox-desc">현재 진행 중인 이벤트입니다.</p>
            <div class="gallery ">
              <div id="owl-demo" class="owl-carousel owl-theme">
              	<c:forEach items="${mainContent.eventList }" var="evnetVo">
              		<div class="item">
              			<a href="${evnetVo.eventLink }">
              				<img src="${pageContext.request.contextPath}/upload/${evnetVo.eventImg}" alt="">
              			</a>
              		</div>
              	</c:forEach>
              </div>
            </div>
            <!-- Gallery -->
          </article>
          <!-- column4 -->
          <article class="cbox column5">
            <h4 class="cbox-title">이미지</h4>
            <p class="cbox-desc">최근에 올라온 이미지들을 확인하세요</p>
            <div class="square clearfix" id="lightgallery">
              <c:forEach items="${mainContent.imgList }" var="imgVo">
              	<a href="${pageContext.request.contextPath}/upload/${imgVo.IMGNAME}"><img src="${pageContext.request.contextPath}/upload/${imgVo.IMGNAME}" alt=""></a>
              </c:forEach>
            </div>

            <!-- Square -->
          </article>
          <!-- column5 -->
          <article class="cbox column6">
            <h4 class="cbox-title">Video</h4>
            <p class="cbox-desc">추천 유튜브</p>
            <div class="video">
              <!-- <video controls="controls" autoplay="autoplay" loop="loop">
                <source src="${pageContext.request.contextPath}/assets/video/video.mp4" type="video/mp4">
              </video> -->
              <div class="video-container">
                <iframe class="iframe" src="https://www.youtube.com/embed/8WaNj-QAQa0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
            <!-- video -->
          </article>
          <!-- column6 -->
        </section>
        <!-- cont-center -->

        <jsp:include page="/WEB-INF/views/include/rightSide.jsp" />
      </div>
    </section>

    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/lightgallery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/modal.js"></script>
</html>

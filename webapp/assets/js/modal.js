//모달의 취소 영역 클릭 시
$(".modal_cancell_ground").on("click", function(){
  $('html').css('overflow', 'auto');
  $(this).parent().css("display", "none");
});

// modalOpen class가 있는 태그를 클릭할 경우
$(".modalOpen").on("click", function(){
  $('html').css('overflow', 'hidden');

  var scroll = $(document).scrollTop();
  var text = 'calc(50% + ' + scroll  + 'px)';
  $('.modal_background ').css('top', text);

  $("#"+$(this).data("id")).css("display", "block");
});

//  modalClose class가 있는 태그를 클릭한 경우
$(".modalClose").on("click", function(){
  $('html').css('overflow', 'auto');
  $(".modal").css("display", "none");
});

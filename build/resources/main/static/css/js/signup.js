// 아이디 유효성 검사
$(function(){
    $("memberId").keyup(function(){ // 해당 태그에 키보드가 눌렀을때 이벤트
        var memberId=$("#memberId").val();
        var memberidj=/^[a-z0-9]{5,15}$/ // 정규표현식(영소문자 5~15 글자만 허용)

        if(@memberidj.test(memberId)) { // 정규 표현식이 다를 경우
            $("#memberIdcheck").html("영소문자 5~15 글자만 가능합니다.");
        } else {
            $.ajax({
                url : "/member/"
            })
        }
    })
});
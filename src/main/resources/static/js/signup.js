$(function() {
    // 아이디 유효성 검사
    //수정 완료 정상 작동
    $("#memberId").keyup(function() { // 해당 태그에 키보드가 눌렀을때 이벤트
        var memberId = $("#memberId").val();
        var memberidj = /^[a-z0-9]{5,15}$/;
        if (!memberidj.test(memberId)) { // 정규 표현식이 다를 경우
            $("#memberIdcheck").html("영소문자 5~15 글자만 가능합니다.");
        } else {
            $.ajax({
                url: "/member/memberidcheck",
                data: { "memberId": memberId },
                success: function(result) {
                    if (result == 1) {
                        $("#memberIdcheck").html("현재 사용중인 아이디 입니다.");
                    } else {
                        $("#memberIdcheck").html("사용가능");
                    }
                }
            });
        }
    });

    // 비밀번호 유효성 검사 [ 수정 완료 작동 확인 03-16 조지훈 ]
    $("#memberPassword").keyup(function() {
        var memberPasswordj = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,15}$/;
        var memberPassword = $("#memberPassword").val();

        if (!memberPasswordj.test(memberPassword)) {
            $("#memberPasswordcheck").html("영대소문자+숫자+특수문자[ !@#$%^&*()+|= ] 8~15포함");
        } else {
            $("#memberPasswordcheck").html("사용가능");
        }
    });


    // 비밀번호 확인 유효성 검사 [ 수정 완료 작동 확인 03-16 조지훈]
    $("#memberPasswordconfirm").keyup(function() {
        var memberPasswordj = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,15}$/;
        var memberPassword = $("#memberPassword").val();
        var memberPasswordconfirm = $("#memberPasswordconfirm").val();
        if (!memberPasswordj.test(memberPasswordconfirm)) {
            $("#memberPasswordconfirmcheck").html("영대소문자+숫자+특수문자[ !@#$%^&*()+|= ] 8~15포함");
        } else if (memberPassword != memberPasswordconfirm) {
            $("#memberPasswordconfirmcheck").html("비밀번호가 일치하지 않습니다.");
        } else {
            $("#memberPasswordconfirmcheck").html("사용가능");
        }
    });

    // 이름 유효성 검사 [ 수정 완료 작동 확인 03-16 조지훈]
    $("#memberName").keyup(function() {
        var memberNamej = /^[A-Za-z가-힣]{1,15}$/;
        var memberName = $("#memberName").val();
        if (!memberNamej.test(memberName)) {
            $("#memberNamecheck").html("영대문자, 한글 1~15 허용");
        } else {
            $("#memberNamecheck").html("사용가능");
        }
    });


    // 연락처 유효성 검사 [ 작동 확인 ]
    $("#memberPhone").keyup(function() {
        var memberPhonej = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        var memberPhone = $("#memberPhone").val();
        if (!memberPhonej.test(memberPhone)) {
            $("#memberPhonecheck").html("01X-XXXX-XXXX 형식으로 입력 해 주세요");
        } else {
            $("#memberPhonecheck").html("사용가능");
        }
    });


    // 이메일 유효성 검사 [ 수정 완료 작동 확인 03-16 조지훈]
    $("#memberEmail").keyup(function() {
        var memberEmailj = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        var memberEmail = $("#memberEmail").val();
        if (!memberEmailj.test(memberEmail)) {
            $("#memberEmailcheck").html("이메일 형식으로 입력 해 주세요");
        } else {
            $.ajax({ // 이메일 중복체크 비동기 통신
                url: "/member/memberemailcheck",
                data: { "memberEmail": memberEmail },
                success: function(result) {
                    if (result == 1) {
                        $("#memberEmailcheck").html("현재 사용중인 이메일 입니다.");
                    } else {
                        $("#memberEmailcheck").html("사용가능");
                    }
                }
            });
        }
    });

    // 주소에 / 입력 제한 [ 수정 완료 작동 확인 03-16 조지훈 ]
    $("#sample4_postcode").keyup(function() {
        var address1 = $("#sample4_postcode").val();
        if (address1.indexOf("/") != -1) {
            $("#memberAddresscheck").html("주소에 '/' 특수문자 포함 불가");
            return false;
        }
        if (address1 != null) {
            $("#memberAddresscheck").html("사용가능");
        }
    });
    $("#sample4_roadAddress").keyup(function() {
        var address2 = $("#sample4_roadAddress").val();
        if (address2.indexOf("/") != -1) {
            $("#memberAddresscheck").html("주소에 '/' 특수문자 포함 불가");
            return false;
        }
        if (address2 != null) {
            $("#memberAddresscheck").html("사용가능");
        }
    });
    $("#sample4_jibunAddress").keyup(function() {
        var address3 = $("#sample4_jibunAddress").val();
        if (address3.indexOf("/") != -1) {
            $("#memberAddresscheck").html("주소에 '/' 특수문자 포함 불가");
            return false;
        }
        if (address3 != null) {
            $("#memberAddresscheck").html("사용가능");
        }
    });
    $("#sample4_detailAddress").keyup(function() {
        var address4 = $("#sample4_detailAddress").val();
        if (address4.indexOf("/") != -1) {
            $("#memberAddresscheck").html("주소에 '/' 특수문자 포함 불가");
            return false;
        }
        if (address4 != null) {
            $("#memberAddresscheck").html("사용가능");
        }
    });

    // 회원가입 모든 유효성 검사 [ 수정 완료 작동 확인 03-16 조지훈]
    $("#formsubmit").click(function() {
        if (!$('input[name=memberSignup]').is(":checked")) {
            alert("회원가입 약관 동의시 회원가입이 가능합니다.");
        } else if (!$('input[name=memberInfosignup]').is(":checked")) {
            alert("개인정보처리방침 동의시 회원가입이 가능합니다.");
        } else if ($("#memberIdcheck").html() != "사용가능") {
            alert("아이디를 확인해 주세요");
        } else if ($("#memberPasswordcheck").html() != "사용가능") {
            alert("비밀번호를 확인해 주세요");
        } else if ($("#memberPasswordconfirmcheck").html() != "사용가능") {
            alert("비밀번호를 확인해 주세요");
        } else if ($("#memberNamecheck").html() != "사용가능") {
            alert("이름을 확인해 주세요");
        } else if ($("#memberPhonecheck").html() != "사용가능") {
            alert("연락처를 확인해 주세요");
        } else if ($("#memberEmailcheck").html() != "사용가능") {
            alert("이메일을 확인해 주세요");
        } else if ($("#memberAddresscheck").html() != "사용가능") {
            alert("주소를 확인해 주세요");
        } else {
            $("form").submit(); // 모든 유효성검사 통과시 폼 전송
        }
    });

}); // 함수 End
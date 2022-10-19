
function categoryWriteModal(cmd) {
      $("#categoryNo").removeAttr("disabled");  // disabled 해제
      $("#categoryNo").val("1");
      $("#categoryName").val("");
      $("#cmd").val(cmd);
      $("#registrationmodal").modal("show");
}
function categoryregistration() {
    let url1;
    let message;
    let failMessage;
    let dataSet;

    $("#categoryNo").removeAttr("disabled");  // disabled 해제

    let categoryNo = $("#categoryNo").val();
    let categoryName = $("#categoryName").val().trim();
    let cmd = $("#cmd").val();

    if(categoryNo == null || categoryNo == "") {
        alert("오류가 발생했습니다. 새로고침 후 다시 시도해주시기 바랍니다.");
        return false;
    }

    if(categoryName == null || categoryName == "") {
        alert("카테고리명을 입력해주시기 바랍니다.");
        $("#categoryName").val("");
        return false;
    }

    if(cmd == 'I') {
        url1 = "/admin/categorywrite"; // 카테고리 등록 페이지
        message = "등록 성공하였습니다.";
        failMessage = "등록 실패하였습니다.";
        dataSet = { "categoryNo": categoryNo, "categoryName": categoryName};
    }  else if(cmd == 'U') {
        url1 = "/admin/updateCategory";
        message = "수정 성공하였습니다.";
        failMessage = "수정 실패하였습니다.";
        dataSet = {"categoryName": categoryName, "upCatNo" : $("#upCatNo").val(), "upCatDiv" : $("#upCatDiv").val() };
    }

    $.ajax({
        url: url1,
        data: dataSet,
        method : "POST",
        success: function(result) {
           if (result == 1) {
             alert(message);
             $(".btn-close").trigger('click');
             location.reload();
           } else {
             alert(failMessage);
             return false;
           }
        }
    });
}

function catDelCheck(categoryNo, catDiv) {

    $("#delCatNo").val(categoryNo);
    $("#delCatDiv").val(catDiv);
}

function categoryDelete(){
    let categoryNo = $("#delCatNo").val();
    let catDiv = $("#delCatDiv").val();

    if(categoryNo == null || categoryNo == "" || catDiv == null || catDiv == "") {
        alert("오류가 발생했습니다. 새로고침 후 다시 시도해주시기 바랍니다.");
        return false;
    }

    $.ajax({
        url: "/admin/categoryDelete",
        method: "POST",
        data : {"categoryNo": categoryNo, "catDiv": catDiv},
        success: function(result) {
            if (result) {
                alert("정상적으로 삭제되었습니다.");
                    location.href = "/admin/categoryregistration";
            } else {
                alert("삭제 실패하였습니다. 관리자에게 문의하여 주세요");
                return false;
            }
        }
    });

}

function categoryUpdateInfo(cmd, categoryNo, catDiv, categoryName){
    $("#cmd").val(cmd); // cmd 값 설정

    if(catDiv != null && catDiv == 1) {
        $("#categoryNo").val("1");
        $("#categoryNo").attr("disabled", "disabled"); // select 박스 잠금
    } else if (catDiv != null && catDiv == 2) {
        $("#categoryNo").val("2");
        $("#categoryNo").attr("disabled", "disabled"); // select 박스 잠금
    }
    $("#categoryName").val(categoryName);
    $("#upCatNo").val(categoryNo);
    $("#upCatDiv").val(catDiv);

}
var url1 = "/admin/categoryregistration"; // 카테고리 등록 페이지

function categoryregistration() {
    var categoryNo = $("#categoryNo").val();
    var categoryName = $("#categoryName").val().trim();

    if(categoryNo == null || categoryNo == "") {
        alert("오류가 발생했습니다. 새로고침 후 다시 시도해주시기 바랍니다.");
        return false;
    }

    if(categoryName == null || categoryName == "") {
        alert("카테고리명을 입력해주시기 바랍니다.");
        $("#categoryName").val("");
        return false;
    }

    $.ajax({
        url: "/admin/categorywrite",
        data: { "categoryNo": categoryNo, "categoryName": categoryName },
        success: function(result) {
               if (result == 1) {
                 alert("등록성공");
                 $(".btn-close").trigger('click');
                 location.href = url1;
               } else {
                 alert("등록 실패");
               }
        }
    });
}

function categoryDelete(){

}
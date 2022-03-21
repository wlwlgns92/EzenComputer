function categoryregistration() {
    var categoryNo = $("#categoryNo").val();
    var categoryName = $("#categoryName").val();

    $.ajax({
        url: "/admin/categorywrite",
        date:{"categoryNo" : categoryNo, "categoryName" : categoryName},
        method: "get",
        success: function(result) {
            if(result == 1) {
                alert("등록성공");
            }else {
                alert("등록실패");
            }
        }
    });

}
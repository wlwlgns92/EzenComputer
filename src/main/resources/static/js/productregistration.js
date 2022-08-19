function searchCTList(componentcategoryNo) {
    var viewHtml = "";
    $.ajax({
        url : "/admin/searchCTList",
        data : {"componentcategoryNo" : componentcategoryNo},
        type : "POST",
        dataType : "json",
        success : function(data) {
            for(var i = 0; i < data.CTinfo[i].length; i++) {
                viewHtml += '<tr>';
                viewHtml += '<td>';
                viewHtml += "<span>" +data.CTinfo[i].componentNo+"</span>";
                viewHtml += '</td>';
                viewHtml += '</tr>';
                console.log("i값===" + i);
                $("#componenttable").append(viewHtml);
            }
        }
    });
}

function CTpick (componentNo, componentCategoryNo) {
    alert("부품번호" + componentNo + "카테고리 번호 " + componentCategoryNo);
    /*$.ajax({
        url: "/admin/CTpick",
        data: {"componentNo" : componentNo, "componentCategoryNo" : componentCategoryNo},
        method: "post",
        success: function(data) {
            alert(data);
            return data;
        }
    });*/

}
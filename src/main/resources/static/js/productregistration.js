function searchCTList(componentcategoryNo) {
    $.ajax({
        url : "/admin/searchCTList",
        data : {"componentcategoryNo" : componentcategoryNo},
        type : "POST",
//        dataType : "json",
//        async : false,
        success : function(data) {
            $("#componenttable").replaceWith(data);
//            for(var i = 0; i < data.CTinfo.length; i++) {
//                var viewHtml = "";
//                viewHtml += "<tr><td><span>"+data.CTinfo[i].componentNo+"</span></td></tr>";
//                $("#componenttable").append(viewHtml);
//                console.log(viewHtml);
//            }
//            var viewHtml = "";
//            console.log(data);
//            viewHtml += '<tr th:each="CTInfo : ${'+data.CTinfo+'}">';
//            viewHtml += '<td><span th:text="${CTInfo.componentNo}"></span> </td>';
//            viewHtml += '</tr>';
//            $("#componenttable").append(viewHtml);
//            console.log(viewHtml);
        }
    });
}



function CTpick (componentNo, componentCategoryNo, componentTitle, componentPrice) {
    $("#pickDiv"+componentCategoryNo).show();
    $("#pickTitle"+componentCategoryNo).text(componentTitle);
    $("#pickPrice"+componentCategoryNo).text(componentPrice);

    var pickTitle = $("#pickTitle"+componentCategoryNo).text();
    var pickPrice = $("#pickPrice"+componentCategoryNo).text();
    if(componentCategoryNo == 1) {
        $("#pickCpu").val();
    } else if(componentCategoryNo == ){
        $("#Vga").val();
    }else if(componentCategoryNo == ){
        $("#").val();
    }else if(componentCategoryNo == ){
        $("#").val();
    }else if(componentCategoryNo == ){
        $("#").val();
    }else if(componentCategoryNo == ){
        $("#").val();
    }

}

function CTDelete(componentCategoryNo) {
    $("#pickTitle"+componentCategoryNo).text("");
    $("#pickPrice"+componentCategoryNo).text("");

}

function CPRegistration() {

}
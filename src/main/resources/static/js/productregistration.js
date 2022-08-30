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
    var compoTotalPrice = 0;
    var pickPrice;
    $("#pickDiv"+componentCategoryNo).show();
    $("#pickTitle"+componentCategoryNo).text(componentTitle);
    $("#pickPrice"+componentCategoryNo).text(componentPrice);

    $("#pickTitle"+componentCategoryNo).text();
    $("#pickPrice"+componentCategoryNo).text();
    $("#pickComponent"+componentCategoryNo).val(componentNo);

    for(var i = 1; i < 6; i++) {
        pickPrice = $("#pickPrice"+i).text();
        if(pickPrice == "") {
            pickPrice = "0";
        }
        compoTotalPrice += parseInt(pickPrice);
        console.log(compoTotalPrice);
    }
    $("#compoTotalPrice").text(compoTotalPrice);
}

function CTDelete(componentCategoryNo) {
    $("#pickTitle"+componentCategoryNo).text("");
    $("#pickPrice"+componentCategoryNo).text("");
    $("#pickComponent"+componentCategoryNo).val("");
    $("#pickDiv"+componentCategoryNo).hide();

}

function CPRegistration() {

}
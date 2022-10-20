function searchCTList(componentcategoryNo) {

    $.ajax({
        url : "/admin/searchCTList",
        data : {"componentcategoryNo" : componentcategoryNo},
        type : "POST",
//        dataType : "json",
//        async : false,
        success : function(data) {
            $("#componenttable").replaceWith(data);
        }
    });
}

function trDelete(){
    $("#componenttable > tbody").empty();
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
    var pickComponent = {
        pickCpu : $("#pickComponent1").val()
        , pickVga : $("#pickComponent2").val()
        , pickCase : $("#pickComponent3").val()
        , pickRam : $("#pickComponent4").val()
        , pickSsd : $("#pickComponent5").val()
        , pickPower : $("#pickComponent6").val()
    }
    $.ajax({
        url : "/admin/completeProductHandle",
        type : "POST",
        dataType : "json",
        data : pickComponent,
        success : function(data) {

        }
    });
}
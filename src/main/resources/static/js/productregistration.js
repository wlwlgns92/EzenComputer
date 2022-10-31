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
    /*
        1. 담기 클릭시 부품번호, 부품카테고리번호, 부품명, 부품가격 인수로 받음
        2. 인수를 hidden 값에 담는다.
        3.
    */
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
    let pickComponent = $("input[name=pickComponent]").length;
    let pickList = new Array(pickComponent);

    for(let i = 0; i<pickComponent; i++) {
        pickList[i] = $("input[name=pickComponent]").eq(i).val();
    }
    if( pickList[0] == ""){
        alert("CPU는 필수로 선택하셔야합니다.");
        return false;
    }
    if( pickList[2] == ""){
        alert("CASE는 필수로 선택하셔야합니다.");
        return false;
    }
    if( pickList[3] == ""){
        alert("RAM은 필수로 선택하셔야합니다.");
        return false;
    }
    if( pickList[4] == ""){
        alert("저장장치(SSD / HDD)는 필수로 선택하셔야합니다.");
        return false;
    }
    if( pickList[5] == ""){
        alert("Power는 필수로 선택하셔야합니다.");
        return false;
    }
    if( pickList[6] == ""){
        alert("MainBoard는 필수로 선택하셔야합니다.");
        return false;
    }

    $.ajax({
        url : "/admin/completeProductHandle",
        type : "POST",
        dataType : "json",
        data : pickList,
        success : function(data) {
        }
    });
}


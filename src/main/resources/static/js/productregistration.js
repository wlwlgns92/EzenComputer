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
    // console.log("부품번호 : " + componentNo + " 카테고리번호 : " + componentCategoryNo + " 부품명 : " + componentTitle + " 부품 가격 : " + componentPrice);
    var compoTotalPrice = 0;
    var pickPrice;
    var compoPrice = componentPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    $("#pickDiv"+componentCategoryNo).show();
    $("#pickTitle"+componentCategoryNo).text(componentTitle);
    $("#pickPrice"+componentCategoryNo).text(compoPrice);

    $("#pickComponent"+componentCategoryNo).val(componentNo);
    $("#pickCategoryNo"+componentCategoryNo).val(componentCategoryNo);

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
    // 카테고리 번호 배열 선언
    let pickCategoryNo = $("input[name=pickCategoryNo]").length;
    let pickCategoryList = new Array(pickCategoryNo);

    // 부품번호 배열 선언
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
    console.log(pickList);
    $.ajax({
        url : "/admin/completeProductHandle",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(pickList),
        success : function(data) {
        }
    });
}


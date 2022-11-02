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

function CTpick (componentNo, componentCategoryNo, componentTitle, componentPrice, componentStock) {
    // console.log("부품번호 : " + componentNo + " 카테고리번호 : " + componentCategoryNo + " 부품명 : " + componentTitle + " 부품 가격 : " + componentPrice);
    var compoTotalPrice = 0;
    var pickPrice;
    var compoPrice = componentPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    $("#pickDiv"+componentCategoryNo).show();
    $("#pickTitle"+componentCategoryNo).text(componentTitle);
    $("#pickPrice"+componentCategoryNo).text(compoPrice);
    $("#pickStock"+componentCategoryNo).val(componentStock);
    $("#pickComponent"+componentCategoryNo).val(componentNo);
    $("#pickCategoryNo"+componentCategoryNo).val(componentCategoryNo);

    //alert("카테고리 : " + componentCategoryNo + " 수량 : " + componentStock);
    for(var i = 1; i < 6; i++) {
        pickPrice = $("#pickPrice"+i).text().replace(/,/g , ''); // 가져온 값의 콤마 제거

        if(pickPrice == "") {
            pickPrice = "0";
        }
        compoTotalPrice += parseInt(pickPrice); // 정수형으로 형변환 후 연산
    }
    compoTotalPrice = compoTotalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 값에 따라 콤마 설정후 변수에 저장
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

    // 부품의 수량체크를 위해 배열 선언
    let countStock = $("input[name=pickStock]").length;
    let listStock = new Array(countStock);
    let cpStock = $("#cpStock").val();

    for(let i = 0; i < listStock.length; i++) {
        listStock[i] = $("input[name=pickStock]").eq(i).val();
        console.log(i+"번째 수량 : " + parseInt(listStock[i]) + " ### 입력한 부품 수량 : "+ parseInt(cpStock));
 /*       if(listStock[i] < cpStock) {
            alert("선택하신 부품 중 수량이 부족한 부품이 있습니다.");
            console.log(listStock[i]);
            return false;
//            console.log(listStock[i] < parseInt(cpStock) + "참트루" );
//            console.log(listStock[i], parseInt(cpStock));
        }*/
    }

    for(let i = 0; i<pickComponent; i++) {
        pickList[i] = $("input[name=pickComponent]").eq(i).val();
    }
//    if($("#cpCategory").val() == "") {
//        alert("카테고리를 선택해 주세요");
//        return false;
//    }
//    if( pickList[0] == ""){
//        alert("CPU는 필수로 선택하셔야합니다.");
//        return false;
//    }
//    if( pickList[2] == ""){
//        alert("CASE는 필수로 선택하셔야합니다.");
//        return false;
//    }
//    if( pickList[3] == ""){
//        alert("RAM은 필수로 선택하셔야합니다.");
//        return false;
//    }
//    if( pickList[4] == ""){
//        alert("저장장치(SSD / HDD)는 필수로 선택하셔야합니다.");
//        return false;
//    }
//    if( pickList[5] == ""){
//        alert("Power는 필수로 선택하셔야합니다.");
//        return false;
//    }
//    if( pickList[6] == ""){
//        alert("MainBoard는 필수로 선택하셔야합니다.");
//        return false;
//    }
//
//    if($("#cpName").val() == "") {
//        alert("제품명을 입력해 주세요");
//        return false;
//    }
//    if($("#cpStock").val() == "") {
//        alert("수량을 입력해 주세요");
//        return false;
//    }
//    if($("#cpPrice").val() == "") {
//        alert("가격을 입력해 주세요");
//        return false;
//    }
    let cpInfo = {
        "cpName" : $("#cpName").val(),
        "cpStock" : $("#cpStock").val(),
        "cpPrice" : $("#cpPrice").val(),
        "cpCategory" : $("#cpCategory").val()
    };

    console.log(cpInfo);
    console.log(pickList);
    $.ajax({
        url : "/admin/completeProductHandle",
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(pickList, cpInfo),
        success : function(data) {
        }
    });
}


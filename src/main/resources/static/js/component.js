function CToutput(componentcategoryNo) {
    $.ajax({
        url: "/component/CToutput",
        data: { "componentcategoryNo": componentcategoryNo }
    }).done(function(fragment) {
        $("#listbox").replaceWith(fragment);
    });
}

function cartadd(componentNo) {

    $.ajax({
        url: "",
        data: {},
        success: function(result) {
            if (confirm("장바구니에 담았습니다. 장바구니 페이지로 이동하시겠습니까? ") == true) {
                location.href = "/cart/productcart";
            }
        }
    });
}
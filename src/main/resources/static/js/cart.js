function stockplus(type, cartNo, stock, componentStock, price) {
  var cartStock = $("#stock"+cartNo).val()*1;
   if(type == 'p'){
    cartStock += 1; 
    $("#stock"+cartNo).val(cartStock);
    var totalprice = cartStock*price; // 수량 * 가격
    $("#price"+cartNo).html(totalprice);
    if(cartStock > componentStock){
        alert("재고가 부족합니다.");
        cartStock = componentStock;
        $("#stock"+cartNo).val(cartStock);
        var totalprice = cartStock*price; // 수량 * 가격
        $("#price"+cartNo).html(totalprice);
    }
   } else if(type == 'm'){
    cartStock -= 1; 
    $("#stock"+cartNo).val(cartStock);
    var totalprice = cartStock*price; // 수량 * 가격
    $("#price"+cartNo).html(totalprice);
    if(cartStock < 1) {
        alert("1개 이상 주문이 가능합니다.");
        cartStock = 1;
        $("#stock"+cartNo).val(cartStock);
        var totalprice = cartStock*price; // 수량 * 가격
        $("#price"+cartNo).html(totalprice);
    }
   } else { // 수량 직접 변경
    if(cartStock > componentStock){
        alert("재고가 부족합니다.");
        cartStock = componentStock;
        $("#stock"+cartNo).val(cartStock);
        var totalprice = cartStock*price; // 수량 * 가격
        $("#price"+cartNo).html(totalprice);
    }
    if(cartStock < 1) {
        alert("1개 이상 주문이 가능합니다.");
        cartStock = 1;
        $("#stock"+cartNo).val(cartStock);
        var totalprice = cartStock*price; // 수량 * 가격
        $("#price"+cartNo).html(totalprice);
    }
    var totalprice = cartStock*price; // 수량 * 가격
    $("#price"+cartNo).html(totalprice);
   }
}

function cartdelete(cartNo) {
    $.ajax({
        url: "/cart/cartdelete",
        data: {"cartNo" : cartNo},
        success: function(result) {

        }
    });
}
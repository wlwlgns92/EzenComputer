function stockplus(type, cartNo, stock, componentStock) {
  var cartStock = $("#stock"+cartNo).val()*1;

   if(type == 'p'){
    cartStock += 1; 
    $("#stock"+cartNo).val(cartStock);
    if(cartStock > componentStock){
        alert("재고가 부족합니다.");
        cartStock = componentStock;
        $("#stock"+cartNo).val(cartStock);
    }
   } else if(type == 'm'){
    cartStock -= 1; 
    $("#stock"+cartNo).val(cartStock);
    if(cartStock < 1) {
        alert("1개 이상 주문이 가능합니다.");
        cartStock = 1;
        $("#stock"+cartNo).val(cartStock);
    }
   } else { // 수량 직접 변경
    if(cartStock > componentStock){
        alert("재고가 부족합니다.");
        cartStock = componentStock;
        $("#stock"+cartNo).val(cartStock);
    }
    if(cartStock < 1) {
        alert("1개 이상 주문이 가능합니다.");
        cartStock = 1;
        $("#stock"+cartNo).val(cartStock);
    }
   }
    
}
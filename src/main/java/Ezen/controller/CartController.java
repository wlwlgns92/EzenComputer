package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "cart")
public class CartController {
    
    // 카트 페이지 맵핑
    @GetMapping("/productcart")
    public String productcart() {
        return "cart/productcart";
    }
    
    // 결제 페이지 맵핑
    @GetMapping("/productpay")
    public String productpay() {
        return "cart/productpay";
    }
}

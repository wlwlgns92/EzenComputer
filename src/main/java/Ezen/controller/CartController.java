package Ezen.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Ezen.domain.entity.MemberEntity;
import antlr.collections.List;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    
    @Autowired
    HttpServletRequest request;

    // 카트 페이지 맵핑
    @GetMapping("/productcart")
    public String productcart() {
        return "cart/productcart";
    }

    // 카트에 담기
    @GetMapping("/cartadd")
    @ResponseBody
    public String cartadd(@RequestParam("componentNo") int componentNo) {
        HttpSession session = request.getSession();
        MemberEntity entity = (MemberEntity)session.getAttribute("loginEntity");
        String cartinfo = "cart" + entity.getMemberId();

        List<MemberEntity> cartlist = (List)session.getAttribute(cartinfo);

        return "";
    } 
    
    // 결제 페이지 맵핑
    @GetMapping("/productpay")
    public String productpay() {
        return "cart/productpay";
    }
}

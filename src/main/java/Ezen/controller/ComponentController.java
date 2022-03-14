package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/component")
public class ComponentController {

    @GetMapping("/amd")
    public String amd(){
        return "product/productcart.html";
    }
}

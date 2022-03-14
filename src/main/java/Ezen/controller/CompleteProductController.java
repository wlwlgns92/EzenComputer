package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/CP")
public class CompleteProductController {

    // amd 완제품 페이지 맵핑
    @GetMapping("/amdlist")
    public String amdlist () {
        return "completeproduct/amdlist";
    }

    // 게이밍 완제품 페이지 맵핑
    @GetMapping("/gamingpclist")
    public String gamingpclist () {
        return "completeproduct/gamingpclist";
    }

    // // intel 완제품 페이지 맵핑
    @GetMapping("/intellist")
    public String intellist () {
        return "completeproduct/intellist";
    }
    
    // 사무용 완제품 페이지 맵핑
    @GetMapping("/officepclist")
    public String officepclist () {
        return "completeproduct/officepclist";
    }

}

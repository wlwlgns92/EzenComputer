package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/component")
public class ComponentController {
    
    @GetMapping("/list")
    public String componentlist (Model model) {
        return "menu/component";
    }
}

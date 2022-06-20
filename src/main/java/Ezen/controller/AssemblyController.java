package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/assembly")
public class AssemblyController {

    @GetMapping("/list")
    public String assemblyList() {

        return "menu/assembly";
    }
}

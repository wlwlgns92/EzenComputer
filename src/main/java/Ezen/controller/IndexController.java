package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class IndexController {

    @GetMapping("/")
    public String main() {
        String path = System.getProperty("user.dir");
        String dir = path+"\\build\\resources\\main\\static\\componentimg"; // 경로
        System.out.println(dir);
        return "main";
    }
}

package Ezen.controller;

import Ezen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    // 카테고리 페이지 맵핑
    @GetMapping("/categoryregistration")
    public String categoryregistration() {
        return "admin/categoryregistration";
    }

    // 카테고리 등록 
    @GetMapping("/categorywrite")
    @ResponseBody
    public String categorywrite (@RequestParam("categoryNo") int categoryNo,
                                 @RequestParam("categoryName") String categoryName) {

      boolean result = adminService.categorywrite(categoryNo,categoryName);
        if(result) {
            System.out.println("등록실패");
            return "2";
        }else {
            System.out.println("등록성공");
            return "1";
        }
    }
}

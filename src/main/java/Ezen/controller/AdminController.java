package Ezen.controller;

import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String categoryregistration(Model model) {
        List<CPCategoryEntity> CPlist = adminService.CPcategorylist();
        List<ComponentCategoryEntity> CTlist = adminService.CTlist();
        model.addAttribute("CTcategory", CTlist);
        model.addAttribute("CPcategory", CPlist);
        return "admin/categoryregistration";
    }

    // 카테고리 등록 
    @GetMapping("/categorywrite")
    @ResponseBody
    public String categorywrite (@RequestParam("categoryNo") int categoryNo,
                                 @RequestParam("categoryName") String categoryName) {

        System.out.println("##################"+categoryNo);
        System.out.println("##################"+categoryName);

      boolean result = adminService.categorywrite(categoryNo,categoryName);

        if(result) {
            System.out.println("등록실패");
            return "2";
        }else {
            System.out.println("등록성공");
            return "1";
        }
    }

    @GetMapping("/productregistration")
    public String productregistration() {
        return "admin/productregistration";
    }

}

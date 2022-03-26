package Ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.domain.entity.ComponentEntity;
import Ezen.service.AdminService;


@Controller
@RequestMapping(value = "/component")
public class ComponentController {
    
    @Autowired
    AdminService adminService;

    @GetMapping("/list")
    public String componentlist (Model model) {
        List<ComponentCategoryEntity> CTlist = adminService.CTlist();
        model.addAttribute("CTlist", CTlist);
        return "menu/component";
    }

    @GetMapping("/CToutput")
    public String CToutput(@RequestParam("componentcategoryNo") int componentcategoryNo, Model model) {
        List<ComponentEntity> entity = adminService.componentlist(componentcategoryNo);
        model.addAttribute("CTdata" , entity);
        return "menu/component :: #listbox";
    }
}

package Ezen.controller;

import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.domain.entity.ComponentEntity;
import Ezen.service.AdminService;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
      boolean result = adminService.categorywrite(categoryNo,categoryName);

        if(result) {
            System.out.println("등록실패");
            return "2";
        }else {
            System.out.println("등록성공");
            return "1";
        }
    }

    // 제품 등록 페이지 맵핑
    @GetMapping("/productregistration")
    public String productregistration(Model model) {
        List<CPCategoryEntity> cplist = adminService.CPcategorylist();
        List<ComponentCategoryEntity> ctlist = adminService.CTlist();
        model.addAttribute("cplist", cplist);
        model.addAttribute("ctlist", ctlist);
        return "admin/productregistration";
    }

    // 부품 제품등록
    @PostMapping("/CTwrite")
    public String CTwrite(
        @RequestParam("componentcategoryNo") int componentCategoryNo,
        @RequestParam("componentTitle") String componentTitle,
        @RequestParam("componentMaker") String componentMaker,
        @RequestParam("componentPrice") int componentPrice,
        @RequestParam("componentStock") int componentStock,
        @RequestParam("componentImg") MultipartFile file
    ) {
        System.out.println("###########" + componentCategoryNo);
        System.out.println("###########" + componentTitle);
        System.out.println("###########" + componentMaker);
        System.out.println("###########" + componentPrice );
        System.out.println("###########" + componentStock);


        try{
            String uuidfile = null;
            if(!file.getOriginalFilename().equals("")) {
                UUID uuid = UUID.randomUUID();
                uuidfile = uuid.toString() + "_" + file.getOriginalFilename().replaceAll("_", "-");
                String dir = "C:\\EzenComputer\\build\\resources\\main\\static\\componentimg"; // 경로
                String filepath = dir + "/" + uuidfile;
                file.transferTo(new File(filepath));

            }
            // CTcategoryNo,componentTitle,componentPrice,componentStock,uuidfile
            ComponentCategoryEntity CTno = adminService.ctcategory(componentCategoryNo);
            adminService.CTwrite(
                    ComponentEntity.builder()
                            .componentTitle(componentTitle)
                            .componentMaker(componentMaker)
                            .componentPrice(componentPrice)
                            .componentStock(componentStock)
                            .componentImg(uuidfile)
                            .componentCategoryEntity(CTno)
                            .build()
            );
            return "main";
        }catch(Exception e){
            System.out.println("###########에러" + e);
        }
        return "";
    }

    @GetMapping("/CTlist")
    public String CTlist(@RequestParam("componentcategoryNo") int componentcategoryNo, Model model) {
        List<ComponentEntity> entity = adminService.componentlist(componentcategoryNo);
        model.addAttribute("CTinfo" , entity);
        return "admin/productregistration :: #componentlist";
    }

    // 담기 버튼 클릭시 해당 카테고리 밑에 선택한 부품 정보 출력
    @PostMapping("/CTpick")
    public String CTpick (@RequestParam("componentNo") int componentNo, @RequestParam("componentcategoryNo") int componentcategoryNo, Model model) {
        ComponentEntity entity = adminService.CTpick(componentNo);
        model.addAttribute("ctdata"+componentcategoryNo , entity);
        return "admin/productregistration :: #data"+componentcategoryNo;
    }


}

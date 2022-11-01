package Ezen.controller;

import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.domain.entity.ComponentEntity;
import Ezen.service.AdminService;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

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
    @PostMapping("/categorywrite")
    @ResponseBody
    public String categorywrite (@RequestParam("categoryNo") int categoryNo,
                                 @RequestParam("categoryName") String categoryName) {

        if(categoryName == null || categoryName.equals("")) {
            return "2";
        }
        boolean result = adminService.categorywrite(categoryNo,categoryName);

        if(result) {
            return "2";
        }else {
            return "1";
        }
    }

    // 카테고리 삭제
    @PostMapping(value = "/categoryDelete")
    @ResponseBody
    public String categoryDelete(@RequestParam("categoryNo") int categoryNo,
                                 @RequestParam("catDiv") String catDiv) {

        if(categoryNo == 0 || catDiv.equals("")){
            return "2";
        }

        Boolean result = adminService.categoryDelete(categoryNo, catDiv);
        if(result) {
            return "1";
        } else {
            return "2";
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
        try{
            System.out.println("#######" + file.toString());
            String uuidfile = null;
            if(!file.getOriginalFilename().equals("")) {
                UUID uuid = UUID.randomUUID();
                uuidfile = uuid.toString() + "_" + file.getOriginalFilename().replaceAll("_", "-");
                String dir = "C:\\EzenComputer\\build\\resources\\main\\static\\componentimg"; // 경로
                String filepath = dir + "/" + uuidfile;
                System.out.println("#######" + filepath);
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
            return "admin/productregistration";
        }catch(Exception e){
            System.out.println("###########에러" + e);
        }
        return "";
    }

    @GetMapping("/CTlist")
    public String CTlist(@RequestParam("componentcategoryNo") int componentcategoryNo, Model model) {

        return "admin/productregistration";
    }


    @PostMapping("/searchCTList")
    public String searchCTList(@RequestParam("componentcategoryNo") int componentcategoryNo, Model model) {
        List<ComponentEntity> entity = adminService.componentlist(componentcategoryNo);
        model.addAttribute("CTinfo", entity);
        return "admin/productregistration :: #componenttable";
    }

    @ResponseBody
    @PostMapping("/updateCategory")
    public String updateSelect(@RequestParam("categoryName") String categoryName,
                               @RequestParam("upCatNo") int upCatNo,
                               @RequestParam("upCatDiv") String upCatDiv) {

        boolean result = adminService.categoryUpdate(categoryName, upCatNo, upCatDiv);

        if(result) {
            return "1";
        } else {
            return "2";
        }
    }
    @ResponseBody
    @PostMapping("/completeProductHandle")
    public boolean completeProductHandle(@RequestBody String pickList[]) {

        /* 완제품 등록
        *  1. ajax로 부품 데이터 넘겨받기
        *  2. 넘겨 받은 부품의 수량 체크 하나라도 0이라면 return false;
        *  3. 수량체크 후
        * */
        return true;
    }
}

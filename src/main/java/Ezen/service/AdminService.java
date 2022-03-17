package Ezen.service;

import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.domain.repository.CPCategoryRepository;
import Ezen.domain.repository.ComponentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CPCategoryRepository cpCategoryRepository;

    @Autowired
    ComponentCategoryRepository componentCategoryRepository;


//    public boolean categorywrite(String categoryNo, String categoryName){
//
//        CPCategoryEntity cpCategoryEntity = null;
//        ComponentCategoryEntity componentCategoryEntity = null;
//
//        System.out.println(categoryNo);
//        System.out.println(categoryName);
//
//        if(categoryNo.equals("1")) {
//            List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();
//            for(CPCategoryEntity entity : CPlist) {
//                if(!entity.getCpcategoryName().equals(categoryName) && entity.getCpcategoryName() == null) {
//                    cpCategoryEntity.setCpcategoryName(categoryName);
//                    cpCategoryRepository.save(cpCategoryEntity);
//                    return true;
//                }
//                else {
//                    return false;
//                }
//            }
//        }else {
//            List<ComponentCategoryEntity> componentlist = componentCategoryRepository.findAll();
//            for(ComponentCategoryEntity entity : componentlist) {
//                if(!entity.getComponentcategoryName().equals(categoryName) && entity.getComponentcategoryName() == null) {
//                    System.out.println("2테스트");
//                    componentCategoryEntity.setComponentcategoryName(categoryName);
//                    componentCategoryRepository.save(componentCategoryEntity);
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }

    public boolean categorywrite(int categoryNo, String categoryName) {

        
        List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();
        if (categoryNo == 1) {
            for (CPCategoryEntity entity : CPlist) {
                if (entity.getCpcategoryName().equals(categoryName)) {
                    System.out.println("if 등록실패");
                    return true;
                }else {
                    System.out.println("else 들어왔다.");
                    CPCategoryEntity cpCategoryEntity = new CPCategoryEntity();
                     cpCategoryEntity.setCpcategoryName(categoryName);
                     cpCategoryRepository.save(cpCategoryEntity);
                     System.out.println("엔티티 등록성공.");
                     return false;
                }
            }
        }
        return false;
    }
}

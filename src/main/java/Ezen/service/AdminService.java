package Ezen.service;

import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;
import Ezen.domain.repository.CPCategoryRepository;
import Ezen.domain.repository.ComponentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CPCategoryRepository cpCategoryRepository;

    @Autowired
    ComponentCategoryRepository componentCategoryRepository;

    // public boolean categorywrite(String categoryNo, String categoryName){
    //
    // CPCategoryEntity cpCategoryEntity = null;
    // ComponentCategoryEntity componentCategoryEntity = null;
    //
    // System.out.println(categoryNo);
    // System.out.println(categoryName);
    //
    // if(categoryNo.equals("1")) {
    // List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();
    // for(CPCategoryEntity entity : CPlist) {
    // if(!entity.getCpcategoryName().equals(categoryName) &&
    // entity.getCpcategoryName() == null) {
    // cpCategoryEntity.setCpcategoryName(categoryName);
    // cpCategoryRepository.save(cpCategoryEntity);
    // return true;
    // }
    // else {
    // return false;
    // }
    // }
    // }else {
    // List<ComponentCategoryEntity> componentlist =
    // componentCategoryRepository.findAll();
    // for(ComponentCategoryEntity entity : componentlist) {
    // if(!entity.getComponentcategoryName().equals(categoryName) &&
    // entity.getComponentcategoryName() == null) {
    // System.out.println("2테스트");
    // componentCategoryEntity.setComponentcategoryName(categoryName);
    // componentCategoryRepository.save(componentCategoryEntity);
    // return true;
    // } else {
    // return false;
    // }
    // }
    // }
    // return false;
    // }


    public boolean categorywrite(int categoryNo, String categoryName) {
        List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();
        
        if (categoryNo == 1 ) { 
            if(CPlist.size() == 0) {
                CPCategoryEntity categoryEntity = new CPCategoryEntity();
                categoryEntity.setCpcategoryName(categoryName);
                cpCategoryRepository.save(categoryEntity);
                return false;
            }
            for( CPCategoryEntity CPEntity : CPlist ) {
                if(CPEntity.getCpcategoryName().equals(categoryName) ) {
                    return true;
                } else {
                    CPCategoryEntity categoryEntity = new CPCategoryEntity();
                    categoryEntity.setCpcategoryName(categoryName);
                    cpCategoryRepository.save(categoryEntity);
                    return false;
                }
            }
        } else {
            List<ComponentCategoryEntity> componentlist = componentCategoryRepository.findAll();
            if(componentlist.size() == 0) {
                ComponentCategoryEntity componentEntity = new ComponentCategoryEntity();
                componentEntity.setComponentcategoryName(categoryName);
                componentCategoryRepository.save(componentEntity);
                return false;
            }
            for( ComponentCategoryEntity ComponentEntity : componentlist ) {
                if(ComponentEntity.getComponentcategoryName().equals(categoryName) ) {
                    return true;
                } else {
                    ComponentCategoryEntity componentEntity = new ComponentCategoryEntity();
                    componentEntity.setComponentcategoryName(categoryName);
                    componentCategoryRepository.save(componentEntity);
                    return false;
                }
            }
        }
        return true;
    }
}

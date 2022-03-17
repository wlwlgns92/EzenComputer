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
    
    // 카테고리 등록
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
    } // 카테고리 등록 end

    // 완제품 전체 카테고리 
    public List<CPCategoryEntity> CPcategorylist() {
        List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();
        return CPlist;
    }

    // 부품 전체 카테고리
    public List<ComponentCategoryEntity> CTlist() {
        List<ComponentCategoryEntity> CTlist = componentCategoryRepository.findAll();
        return CTlist;
    }
}

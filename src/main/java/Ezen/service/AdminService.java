package Ezen.service;



import Ezen.domain.entity.CPCategoryEntity;
import Ezen.domain.entity.ComponentCategoryEntity;

import Ezen.domain.entity.ComponentEntity;
import Ezen.domain.repository.CPCategoryRepository;
import Ezen.domain.repository.ComponentCategoryRepository;
import Ezen.domain.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    CPCategoryRepository cpCategoryRepository;

    @Autowired
    ComponentCategoryRepository componentCategoryRepository;

    @Autowired
    ComponentRepository componentRepository;


    // 카테고리 등록
    public boolean categorywrite(int categoryNo, String categoryName) {
        if (categoryNo == 1 ) {
            List<CPCategoryEntity> CPlist = cpCategoryRepository.findAll();

            if(CPlist.size() == 0) {
                CPCategoryEntity categoryEntity = new CPCategoryEntity();
                categoryEntity.setCpcategoryName(categoryName);
                categoryEntity.setCatDiv("1");
                cpCategoryRepository.save(categoryEntity);
                return false;
            }
            for( CPCategoryEntity CPEntity : CPlist ) {
                if(CPEntity.getCpcategoryName() != null && CPEntity.getCpcategoryName().equals(categoryName) ) {
                    return true;
                } else {
                    CPCategoryEntity categoryEntity = new CPCategoryEntity();
                    categoryEntity.setCpcategoryName(categoryName);
                    categoryEntity.setCatDiv("1");
                    cpCategoryRepository.save(categoryEntity);
                    return false;
                }
            }
        } else {
            List<ComponentCategoryEntity> componentlist = componentCategoryRepository.findAll();

            if(componentlist.size() == 0) {
                ComponentCategoryEntity componentEntity = new ComponentCategoryEntity();
                componentEntity.setComponentcategoryName(categoryName);
                componentEntity.setCatDiv("2");
                componentCategoryRepository.save(componentEntity);
                return false;
            }
            for( ComponentCategoryEntity ComponentEntity : componentlist ) {
                if(ComponentEntity.getComponentcategoryName().equals(categoryName) ) {
                    return true;
                } else {
                    ComponentCategoryEntity componentEntity = new ComponentCategoryEntity();
                    componentEntity.setComponentcategoryName(categoryName);
                    componentEntity.setCatDiv("2");
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

    // 부품 등록 03.21
    public boolean CTwrite (ComponentEntity componentEntity) {
        try {
            ComponentCategoryEntity ctcategory =  ctcategory(componentEntity.getComponentCategoryEntity().getComponentcategoryNo());
            int componentNo = componentRepository.save(componentEntity).getComponentNo();
            ComponentEntity entity = componentRepository.findById(componentNo).get();
            ctcategory.getComponentEntities().add(entity);
            return true;
        }catch (Exception e) {
            System.out.println("부품 등록 실패" + e);
            return false;
        }
    }

    // 부품 카테고리 번호로 카테고리 Entity 가져오기
    public ComponentCategoryEntity ctcategory (int ctNo) {
        ComponentCategoryEntity entity = componentCategoryRepository.findById(ctNo).get();
        if(entity != null) {
            return entity;
        }else {
            return null;
        }
    }

    // 카테고리 번호로 등록된 부품 가저오기
    public List<ComponentEntity> componentlist (int componentcategoryNo) {

        ComponentCategoryEntity entity = componentCategoryRepository.findById(componentcategoryNo).get();
        List<ComponentEntity> CTEntity = entity.getComponentEntities();
        return CTEntity;
    }

    
    // 담기 버튼 클릭시 해당 카테고리 밑에 선택한 부품 정보 출력
    public ComponentEntity CTpick (int componentNo) {
        ComponentEntity entity = componentRepository.findById(componentNo).get();
        return entity;
    }

    // 카테고리 삭제
    public Boolean categoryDelete(int categoryNo, String catDiv) {
        if(catDiv != null && catDiv.equals("1")){
            cpCategoryRepository.deleteById(categoryNo);
            return true;
        } else if(catDiv != null && catDiv.equals("2")){
            componentCategoryRepository.deleteById(categoryNo);
            return true;
        } else {
            return false;
        }
    }

    // 카테고리 정보 가져오기
    public Map<String, Object> updateSelect(int categoryNo, String catDiv) {
        Map<String, Object> catInfo = new HashMap<String, Object>();

        if(catDiv.equals("1")) {
            CPCategoryEntity cpCategoryEntity = cpCategoryRepository.findById(categoryNo).get();
            catInfo.put("catInfo", cpCategoryEntity);
        } else if (catDiv.equals("2")) {
            ComponentCategoryEntity componentCategoryEntity = componentCategoryRepository.findById(categoryNo).get();
            catInfo.put("catInfo", componentCategoryEntity);
        } else {
            return null;
        }
        return catInfo;
    }

    @Transactional
    public boolean categoryUpdate(String categoryName, int upCatNo, String upCatDiv) {
        try {
            if(upCatDiv.equals("1")) {
                CPCategoryEntity cpCategoryEntity = cpCategoryRepository.findById(upCatNo).get();
                cpCategoryEntity.setCpcategoryName(categoryName);
                return true;
            } else if(upCatDiv.equals("2")) {
                ComponentCategoryEntity componentCategoryEntity = componentCategoryRepository.findById(upCatNo).get();
                componentCategoryEntity.setComponentcategoryName(categoryName);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
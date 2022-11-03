package Ezen.service;



import Ezen.domain.entity.*;

import Ezen.domain.repository.*;
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

    @Autowired
    CompleteProductInfoRepository completeProductInfoRepository;

    @Autowired
    CompleteProductRepository completeProductRepository;

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

    @Transactional
    public boolean completeProductHandle(List<String> pickList, Map<String, Object> cpInfo) {
        /*
        * 1. 인수는 카테고리 번호와 부품번호를 받는다.
        * 2. 부품카테고리 리스트 조회
        * 3. 부품번호로 정보 조회
        * 4. 조회한 부품의 카테고리를 카테고리 리스트와 매칭
        * 5.
        */
        CPCategoryEntity cpCategoryEntity = cpCategoryRepository.findById(Integer.parseInt((String) cpInfo.get("cpCategory"))).get();

        CompleteProductInfoEntity infoEntity = new CompleteProductInfoEntity().builder()
                .cpName((String) cpInfo.get("cpName"))
                .cpPrice((String) cpInfo.get("cpPrice"))
                .cpStock((String) cpInfo.get("cpStock"))
                .cpCategoryEntity(cpCategoryEntity)
                .build();
        try {
            // 완제품 정보 저장
            infoEntity = completeProductInfoRepository.save(infoEntity);
        } catch (Exception e) {
            return false;
        }

        for(int i = 0; i < pickList.size(); i++) {
            if(!pickList.get(i).equals("") && pickList.get(i) != null) {
                ComponentEntity componentEntity = componentRepository.findById(Integer.parseInt(pickList.get(i))).get();
                CompleteProductEntity comple = new CompleteProductEntity().builder()
                        .componentEntity(componentEntity)
                        .completeProductInfoEntity(infoEntity)
                        .build();
                try {
                    completeProductRepository.save(comple);
                    int updateStock = componentEntity.getComponentStock();
                    if(updateStock > 0) {
                        componentEntity.setComponentStock(updateStock - Integer.parseInt((String) cpInfo.get("cpStock")));
                    }
                    // 수량 감소 업데이트도 해야함
                } catch (Exception e) {
                    System.out.println("#######" + e);
                    return false;
                }
            }
        }
        return true;
    }

}
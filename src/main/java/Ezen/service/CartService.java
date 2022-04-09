package Ezen.service;

import Ezen.domain.entity.CartEntity;
import Ezen.domain.entity.ComponentEntity;
import Ezen.domain.entity.MemberEntity;
import Ezen.domain.repository.CartRepository;
import Ezen.domain.repository.ComponentRepository;
import Ezen.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ComponentRepository componentRepository;

    public boolean cartadd (int memberNo ,int componentNo) {
        // 가져온 인수로 해당 Entity를 찾는다.
      ComponentEntity componentEntity = componentRepository.findById(componentNo).get();
      MemberEntity memberEntity = memberRepository.findById(memberNo).get();

        // 만약에 회원의 장바구니에 해당 번호의 상품이 있으면
        try {
            for (CartEntity cartEntities : memberEntity.getCartEntities()) {
                if (cartEntities.getComponentEntity().getComponentNo() == componentNo) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("#############" + e);
        }
        // 찾은 Entity를 CartEntity에 build 초기 수량은 1
        CartEntity cartEntities = CartEntity.builder().cartStock(1).componentEntity(componentEntity).memberEntity(memberEntity).build();
        // 카트 엔티티에 저장후 카트번호를 가져온다.
        int cartNo = cartRepository.save(cartEntities).getCartNo();
        // 카트번호에 해당하는 Entity를 호출한다.
        CartEntity getcartEntity = cartRepository.findById(cartNo).get();
        // 호출한 cartEntity를 부품과 멤버 Entity에 저장한다.
        memberEntity.getCartEntities().add(getcartEntity);
        componentEntity.getCartEntities().add(getcartEntity);
        return true;
    }

    public boolean cartdelete (int cartNo) {
        CartEntity cartEntity = cartRepository.findById(cartNo).get();
        
    }
}

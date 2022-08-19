package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CartEntity {
// 장바구니 Entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartNo")
    private int cartNo;

    @Column // 수량
    private int cartStock;
    
    @ManyToOne
    @JoinColumn(name = "memberNo")
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "componentNo")
    private ComponentEntity componentEntity;

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getCartStock() {
        return cartStock;
    }

    public void setCartStock(int cartStock) {
        this.cartStock = cartStock;
    }

    public ComponentEntity getComponentEntity() {
        return componentEntity;
    }

    public void setComponentEntity(ComponentEntity componentEntity) {
        this.componentEntity = componentEntity;
    }
}

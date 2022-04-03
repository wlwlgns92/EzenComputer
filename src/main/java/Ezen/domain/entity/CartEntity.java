package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@ToString
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

}

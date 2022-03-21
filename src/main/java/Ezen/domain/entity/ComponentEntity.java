package Ezen.domain.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="component")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ComponentEntity {

    // 부품 Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="componentNo") // 부품 번호
    private int componentNo;

    @Column(name = "componentTitle") // 부품 제목
    private String componentTitle;

    @Column(name = "componentPrice") // 부품 가격
    private int componentPrice;

    @Column(name = "componentStock") // 부품 재고
    private int componentStock;

    @Column(name="componentImg") // 부품 이미지
    private String componentImg;


    @ManyToOne
    @JoinColumn(name="componentcategoryNo")
    private ComponentCategoryEntity componentCategoryEntity;
}

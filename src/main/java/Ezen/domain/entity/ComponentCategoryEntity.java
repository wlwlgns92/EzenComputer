package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="componentcategory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ComponentCategoryEntity {

    // 부품 카테고리 Entity Ex) CPU , VGA , RAM ..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="componentcategoryNo")
    private int componentcategoryNo;

    @Column(name="componentcategoryName")
    private String componentcategoryName;
    
    // ComponentCategoryEntity 와 맵핑 예정
    
}

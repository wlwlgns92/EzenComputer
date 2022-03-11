package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="cpcategory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CPCategoryEntity {

    // 완제품 카테고리 Entity Ex) 사무용, 게이밍 ..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryNo") // 완제품 카테고리 번호
    private int categoryNo;

    @Column(name = "categoryName") // 완제품 카테고리명
    private String categoryName;

    // ComponentEntity와 맵핑 예정

}

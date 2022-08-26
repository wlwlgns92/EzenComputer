package Ezen.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "componentMaker") // 제조사
    private String componentMaker;

    @Column(name = "componentPrice") // 부품 가격
    private int componentPrice;

    @Column(name = "componentStock") // 부품 재고
    private int componentStock;

    @Column(name="componentImg") // 부품 이미지
    private String componentImg;

    @OneToMany(mappedBy = "componentEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<CartEntity> cartEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="componentcategoryNo")
    private ComponentCategoryEntity componentCategoryEntity;
}

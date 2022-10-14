package Ezen.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // 카테고리 구분
    @Column(name="catDiv")
    private String catDiv;

    // ComponentEntity 와 맵핑 예정
    @OneToMany(mappedBy = "componentCategoryEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<ComponentEntity> componentEntities = new ArrayList<>();
}

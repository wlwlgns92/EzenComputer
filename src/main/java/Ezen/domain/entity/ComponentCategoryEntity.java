package Ezen.domain.entity;

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
public class ComponentCategoryEntity {

    // 부품 카테고리 Entity Ex) CPU , VGA , RAM ..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="componentcategoryNo")
    private int componentcategoryNo;

    @Column(name="componentcategoryName")
    private String componentcategoryName;
    
    // ComponentEntity 와 맵핑 예정
    @OneToMany(mappedBy = "componentCategoryEntity", cascade = CascadeType.ALL)
    private List<ComponentEntity> componentEntities = new ArrayList<>();
}

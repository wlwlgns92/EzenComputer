package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "completeProductInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CompleteProductInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpInfoNo")
    private int cpInfoNo; // 키값

    @Column(name = "cpImg")
    private String cpImg;   // 이미지

    @Column(name = "cpPrice")
    private String cpPrice; // 가격

    @Column(name = "cpStock")
    private String cpStock; // 수량

    @Column(name = "cpName")
    private String cpName;  // 제품명

    @Column(name = "cpCategory")
    private String cpCategory; // 카테고리

    @ManyToOne
    @JoinColumn(name = "cpcategoryNo")
    private CPCategoryEntity cpCategoryEntity;

    @OneToMany(mappedBy = "completeProductInfoEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CompleteProductEntity> compList = new ArrayList<>();


}

package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="completeproduct")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CompleteProductEntity {

    // 완제품에 사용된 부품 Entity
    /*
    * pk
    * 부품 번호
    * 부붐 카테고리 번호
    * 완제품 정보 번호 FK
    *
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpNo")    // 키값
    private int cpNo;

    @Column(name = "cpCompNo")  // 사용된 부품 번호
    private String cpCompNo;

    @Column(name = "cpCompCatNo") // 사용된 부품 카테고리 번호 [ Cpu, VGA ... ]
    private String vgaNo;

    @ManyToOne // 완제품 카테고리 [ 게이밍.. 사무용 .. ]
    @JoinColumn(name = "cpInfoNo")
    private CompleteProductInfoEntity completeProductInfoEntity;


}

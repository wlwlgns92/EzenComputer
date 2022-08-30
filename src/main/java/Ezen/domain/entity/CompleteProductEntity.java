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

    // 완제품 Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpNo") // 완제품 번호
    private int cpNo;

    @Column(name = "cpImg") // 완제품 이미지
    private String cpImg;

    @Column(name = "cpuNo")
    private String cpuNo;

    @Column(name = "vgaNo")
    private String vgaNo;

    @Column(name ="caseNo")
    private String caseNo;

    @Column(name = "ramNo")
    private String ramNo;

    @Column(name = "ssdNo")
    private String ssdNo;

    @Column(name = "powerNo")
    private String powerNo;

    @Column(name = "cpPrice")
    private String cpPrice;

    @ManyToOne // 완제품 카테고리 [ 게이밍.. 사무용 .. ]
    @JoinColumn(name = "CPCategoryNo")
    private CPCategoryEntity cpCategoryEntity;


}

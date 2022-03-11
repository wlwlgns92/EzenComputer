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

    // CPCompleteProducetEntity 와 맵핑 예정


}

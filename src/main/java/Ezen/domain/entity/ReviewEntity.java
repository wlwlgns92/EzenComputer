package Ezen.domain.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="review")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReviewEntity {

    // review Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reviewNo")
    private int reviewNo;

    @Column(name="reviewContents")
    private String reviewContents;

    // 주문내역을 받아와 리뷰를 작성할 예정

    // reviewImgEntity와 맵핑 예정


}

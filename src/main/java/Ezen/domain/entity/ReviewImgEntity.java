package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reviewImg")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReviewImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reviewImgNo")
    private int reviewImgNo;

    @Column(name="reviewImg")
    private String reviewImg;

    // reviewEntity 와 맵핑 예정

}

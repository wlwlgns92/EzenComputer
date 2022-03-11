package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="coment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ComentEntity {

     // qna에 대한 답글 Entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comentNo") // 답글 번호
    private int comentNo;

    @Column(name="comentContents") // 답글 내용
    private String comentContents;

    // qna 번호가 들어갈 예정

}

package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Qna")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class QnaEntity {

    // QnaEntity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="qnaNo")
    private int qnaNo;

    @Column(name="qnaTitle")
    private String qnaTitle;

    @Column(name="qnaContents")
    private String qnaContents;

    // ComentEntity와 맵핑 예정


}

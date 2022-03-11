package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="link")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LinkEntity {

    // 완제품 등록시 선택한 부품의 번호와 완제품의 번호를 같이 저장하는 엔티티

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="linkNo") // 링크 번호
    private int linkNo;

    // CompleteProductEntity와 맵핑 예정

    // ComponentEntity와 맵핑 예정




}

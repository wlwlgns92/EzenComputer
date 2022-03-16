package Ezen.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name="member")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @ToString
public class MemberEntity {
    // 회원 Entity

    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="memberNo") // 회원 번호
    private int memberNo;

    @Column(name= "memberId") // 회원 아이디
    private String memberId;

    @Column(name="memberPassword") // 회원 비밀번호
    private String memberPassword;
    
    @Column(name="memberName") // 회원 이름
    private String memberName;

    @Column(name="memberPhone") // 회원 연락처
    private String memberPhone;

    @Column(name="memberEmail") // 회원 이메일
    private String memberEmail;

    @Column(name="memberAddress") // 회원 주소
    private String memberAddress;

    // Qna Entity와 맵핑 예정

    // ReviewEntity 와 맵핑 예정

}

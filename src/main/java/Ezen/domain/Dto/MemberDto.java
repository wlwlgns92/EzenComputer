package Ezen.domain.Dto;

import lombok.*;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 풀 생성자
@Getter @Setter @ToString // 객체 주소정보
@Builder
public class MemberDto {
    // 필드
    private int memberNo; // 회원 번호
    private String memberId; // 아이디
    private String memberPassword; // 비밀번호
    private String memberName; // 이름
    private String memberPhone; // 연락처
    private String memberEmail; // 이메일
    private String memberAddress; // 주소


}

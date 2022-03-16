package Ezen.domain.Dto;

import Ezen.domain.entity.MemberEntity;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {
    private int memberNo;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;




}

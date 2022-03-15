package Ezen.controller;

import Ezen.domain.Dto.MemberDto;
import Ezen.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    // member와 관련된 컨트롤러

    // 회원가입 페이지 이동 03-11 조지훈
    @GetMapping("/signup")
    public String sginup() { return "member/signup"; }

    // 로그인 페이지 이동 03-11 조지훈
    @GetMapping("login")
    public String login() { return "member/login"; }

    // 회원가입 처리 연결
    @PostMapping("/member/signupcontroller")
    public String signupcontroller(MemberDto memberDto,
                                   @RequestParam("address1") String address1,
                                   @RequestParam("address2") String address2,
                                   @RequestParam("address3") String address3,
                                   @RequestParam("address4") String address4) {
        memberDto.setMemberAddress(address1+"/"+address2+"/"+address3+"/"+address4);


    }
}

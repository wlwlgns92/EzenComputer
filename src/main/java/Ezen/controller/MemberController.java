package Ezen.controller;

import Ezen.domain.entity.MemberEntity;
import Ezen.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/member")
public class MemberController { // member와 관련된 컨트롤러
    @Autowired
    MemberService memberService;
    @Autowired
    HttpServletRequest httpServletRequest;

    // 회원가입 페이지 이동 03-11 조지훈
    @GetMapping("/signup")
    public String sginup() { return "member/signup"; }

    // 로그인 페이지 이동 03-11 조지훈
    @GetMapping("login")
    public String login() { return "member/login"; }

    // 회원가입 처리 연결
    @PostMapping("/member/signupcontroller")
    public String signupcontroller(MemberEntity memberEntity,
                                   @RequestParam("address1") String address1,
                                   @RequestParam("address2") String address2,
                                   @RequestParam("address3") String address3,
                                   @RequestParam("address4") String address4) {
        memberEntity.setMemberAddress(address1+"/"+address2+"/"+address3+"/"+address4);
        memberService.membersignup(memberEntity);
        return "redirect:/";
    }

    // 아이디 중복 체크
    @GetMapping("/memberidcheck")
    @ResponseBody
    public String memberidcheck(@RequestParam("memberId") String memberId) {
        boolean result = memberService.memberidcheck(memberId);
        if(result) {
            return "1"; // 중복
        } else {
            return "2"; // 중복x
        }
    }

    // 이메일 중복 체크
    @GetMapping("/memberemailcheck")
    @ResponseBody
    public String memberemailcheck(@RequestParam("memberEmail") String memberEmail) {
        boolean result = memberService.memberemailcheck(memberEmail);
        if(result) {
            return "1"; // 중복
        } else {
            return "2"; // 중복x
        }
    }


}

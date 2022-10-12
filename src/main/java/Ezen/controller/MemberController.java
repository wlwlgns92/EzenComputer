package Ezen.controller;

import Ezen.domain.entity.MemberEntity;
import Ezen.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
public class MemberController { // member와 관련된 컨트롤러
    @Autowired
    MemberService memberService;
    @Autowired
    HttpServletRequest request;

    // 회원가입 페이지 이동 03-11 조지훈
    @GetMapping("/signup")
    public String signup() { return "member/signup"; }

    // 로그인 페이지 이동 03-11 조지훈
    @GetMapping("login")
    public String login() { return "member/login"; }

    // 회원가입 처리 연결
    @PostMapping("/signupcontroller")
    public String signupcontroller(MemberEntity memberEntity,
                                   @RequestParam("address1") String address1,
                                   @RequestParam("address2") String address2,
                                   @RequestParam("address3") String address3,
                                   @RequestParam("address4") String address4) {
        memberEntity.setMemberAddress(address1+"/"+address2+"/"+address3+"/"+address4);
        memberService.membersignup(memberEntity);
        return "redirect:/";
    }

    // 로그인 처리
    @PostMapping("/logincontroller")
    @ResponseBody
    public String logincontroller(@RequestParam("memberId") String memberId,
                                    @RequestParam("memberPw") String memberPw) {

            MemberEntity memberEntity = memberService.login(memberId, memberPw);

            if(memberEntity != null)  {
                HttpSession session = request.getSession();
                session.setAttribute("loginEntity", memberEntity);
                return "1";
            }else {
                return "2";
            }

    }

    // 로그아웃 처리
    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        HttpSession session = request.getSession();
        session.setAttribute("loginEntity", null); // 기존 세션을 null로 변경
        return "1"; 
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

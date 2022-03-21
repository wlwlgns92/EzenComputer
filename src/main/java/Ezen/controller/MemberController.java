package Ezen.controller;

import Ezen.domain.entity.MemberEntity;
import Ezen.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // 회원가입 페이지 이동
    @GetMapping("/signup")
    public String signup() { return "member/signup"; }

    // 로그인 페이지 이동
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

    // 로그인처리 [스프링 시큐리티 사용시 로그인처리 메소드 제공 받기 때문에 사용X]
    @PostMapping("/logincontroller")
    @ResponseBody
    public String logincontroller(@RequestBody MemberEntity memberEntity) {
          MemberEntity loginEntity = memberService.login(memberEntity);
          if(loginEntity != null) {
             HttpSession session = request.getSession(); // 서버내 세션 가져오기
              session.setAttribute( "loginEntity", loginEntity); // 세션 설정
              return "1";
          } else {
              return "2";
          }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout() {
        HttpSession session = request.getSession();
        session.setAttribute( "loginEntity", null); // 기존 세션을 null 로 변경
        return "redirect:/"; // 로그아웃 성공시 메인페이지로 이동
    }

    // 회원정보 찾기 페이지로 연결
    @GetMapping("/findid")
    public String findid() {
        return "member/findid";
    }

    @PostMapping("/findidcontroller")
    public String findid(MemberEntity memberEntity, Model model) {
        String result = memberService.findid(memberEntity);
        if(result != null) {
            String findidmsg = "회원님의 아이디 : " + result;
            model.addAttribute("findidmsg", findidmsg);
        } else {
            String findidmsg = "동일한 회원정보가 없습니다.";
            model.addAttribute("findidmsg", findidmsg);
        } return "/member/findid";
    }

    @PostMapping("/findpasswordcontroller")
    public String findpassword(MemberEntity memberEntity, Model model) {
        boolean result = memberService.findpassword(memberEntity);
        if(result){
            String findpasswordmsg = "해당 이메일로 임시 비밀번호를 발송 했습니다.";
            model.addAttribute("findpasswordmsg", findpasswordmsg);
        } return "/member/findid";
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

    // 내 정보(마이페이지) 연결
    @GetMapping("/member/info")
    public String emailcheck(Model model) {
        HttpSession session = request.getSession();
        MemberEntity loginEntity = (MemberEntity)  session.getAttribute("loginEntity");
        MemberEntity memberEntity = memberService.getMemberEntity(loginEntity.getMemberNo());
        model.addAttribute("memberEntity", memberEntity);
        return "member/info";
    }

}

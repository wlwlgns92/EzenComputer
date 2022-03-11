package Ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

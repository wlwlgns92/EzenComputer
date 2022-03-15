package Ezen.service;

import Ezen.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // 회원 등록 메소드
    public boolean membersignup() {

    }
}

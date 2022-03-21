package Ezen.service;

import Ezen.domain.entity.MemberEntity;
import Ezen.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // 회원 등록 메소드
    public boolean membersignup(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
        return true;
    }

    // 회원 로그인 메소드
    public MemberEntity login(MemberEntity memberEntity) {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        for(MemberEntity memberEntitylogin : memberEntityList) {
            if(memberEntity.getMemberId().equals(memberEntity.getMemberId()) &&
                memberEntity.getMemberPassword().equals(memberEntity.getMemberPassword())) {
                return MemberEntity.builder()
                        .memberId(memberEntity.getMemberId())
                        .memberNo(memberEntity.getMemberNo()) .build();
            }
        } return null;
    }

    // 회원 아이디 찾기
    public String findid(MemberEntity memberEntity) {
        // 1. 모든 엔티티 호출
        List<MemberEntity> memberEntities = memberRepository.findAll();
        // 2. 반복문 이용한 모든 엔티티를 하나씩 꺼내보기
        for(MemberEntity memberEntityfindid  :  memberEntities) {
            // 3. 만약에 해당 엔티티가 이름과 이메일이 동일하면
            if( memberEntity.getMemberName().equals(memberEntity.getMemberName()) &&
                    memberEntity.getMemberEmail().equals(memberEntity.getMemberEmail())) {
                return memberEntity.getMemberId(); // 4. 아이디를 반환한다
            }
        }  return null; // 5. 만약에 동일한 정보가 없으면
    }

    // 회원 비밀번호 찾기 → 임시 비밀번호 메일 전송
    public boolean findpassword(MemberEntity memberEntity) {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        for(MemberEntity memberEntityfindpassword : memberEntities) {
            if(memberEntity.getMemberId().equals(memberEntity.getMemberId()) &&
                memberEntity.getMemberEmail().equals(memberEntity.getMemberEmail())) {
                return true;
            }
        } return false;
    }

    // 아이디 중복 체크
    public boolean memberidcheck(String memberId) {
        // 1. 모든 엔티티 가져오기
        List<MemberEntity> memberEntities = memberRepository.findAll();
        // 2. 모든 엔티티 반복문 돌려서 하나씩 가져오기
        for(MemberEntity memberEntity : memberEntities) {
            // 3. 해당 엔티티가 입력한 아이디와 동일 하면
            if(memberEntity.getMemberId().equals(memberId)){
                return true; // 중목   
            }
        } return false; // 중목 없음
    }
    
    // 이메일 중복체크
    public boolean memberemailcheck(String memberEmail){
        List<MemberEntity> memberEntities = memberRepository.findAll();
        for(MemberEntity memberEntity : memberEntities) {
            if(memberEntity.getMemberEmail().equals(memberEmail)) {
                return true; // 중복
            }
        } return false; // 중복 없음
    }
    
    // 회원번호 → 회원정보 반환
    public MemberEntity getMemberEntity(int memberNo) {
        Optional<MemberEntity> entityOptional = memberRepository.findById(memberNo);
        return MemberEntity.builder()
                .memberId(entityOptional.get().getMemberId())
                .memberName(entityOptional.get().getMemberName())
                .memberPhone(entityOptional.get().getMemberPhone())
                .memberEmail(entityOptional.get().getMemberEmail())
                .memberAddress(entityOptional.get().getMemberAddress())
                .build();
    }
    
    
    
    
    
    
}
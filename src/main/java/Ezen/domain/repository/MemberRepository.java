package Ezen.domain.repository;

import Ezen.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // 엔티티 검색 findby 필드명
//    Optional<MemberEntity> findBymemberid(String memberId);
//    Optional<MemberEntity> findBymemberemail(String memberEmail);
}

package Ezen.domain.repository;

import Ezen.domain.entity.QnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<QnaEntity, Integer> {
}

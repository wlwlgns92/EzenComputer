package Ezen.domain.entity.repository;

import Ezen.domain.entity.ComentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<ComentEntity, Integer> {
}

package Ezen.domain.entity.repository;

import Ezen.domain.entity.CompleteProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompleteProductRepository extends JpaRepository<CompleteProductEntity, Integer> {
}

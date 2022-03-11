package Ezen.domain.entity.repository;

import Ezen.domain.entity.ComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<ComponentEntity, Integer> {
}

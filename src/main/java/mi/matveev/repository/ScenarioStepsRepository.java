package mi.matveev.repository;

import mi.matveev.domain.entity.ScenarioStepsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioStepsRepository extends JpaRepository<ScenarioStepsEntity, String> {
}

package mi.matveev.repository;

import mi.matveev.domain.entity.ScenarioStepsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioStepsRepository extends JpaRepository<ScenarioStepsEntity, String> {
    List<ScenarioStepsEntity> findByScenarioId(String scenarioId);
}

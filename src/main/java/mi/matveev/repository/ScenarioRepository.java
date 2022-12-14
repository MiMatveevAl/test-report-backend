package mi.matveev.repository;

import mi.matveev.domain.entity.ScenarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends JpaRepository<ScenarioEntity, String> {
}

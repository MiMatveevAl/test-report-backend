package mi.matveev.repository;

import mi.matveev.domain.entity.RunScenariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunScenariosRepository extends JpaRepository<RunScenariosEntity, String> {
    List<RunScenariosEntity> findByRunId(String runId);
}

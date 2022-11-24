package mi.matveev.repository;

import mi.matveev.domain.entity.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunRepository extends JpaRepository<RunEntity, String> {
    List<RunEntity> findAllByProject(String project);
}

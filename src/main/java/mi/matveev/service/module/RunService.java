package mi.matveev.service.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.repository.RunRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RunService {
    private final RunRepository runRepository;

    public String createRun(RunEntity run) {
        run = run.toBuilder()
                .id(UUID.randomUUID().toString())
                .timeCreated(LocalDateTime.now())
                .build();

        return runRepository.save(run).getId();
    }
}

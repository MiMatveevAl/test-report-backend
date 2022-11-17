package mi.matveev.service.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.domain.enumeration.RunStatus;
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
                .status(RunStatus.IN_PROGRESS)
                .timeCreated(LocalDateTime.now())
                .timeFinished(null)
                .build();

        return runRepository.save(run).getId();
    }

    public Void finishRun(String runId, RunStatus status) {
        RunEntity run = runRepository.findById(runId)
                .orElseThrow(() -> new NullPointerException("Run with id - '" + runId + "' not found"))
                .toBuilder()
                .status(status)
                .timeFinished(LocalDateTime.now())
                .build();
        runRepository.save(run);

        return null;
    }
}

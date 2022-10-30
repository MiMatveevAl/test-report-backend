package mi.matveev.service;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.api.CreateRunRequestDto;
import mi.matveev.domain.api.GetRunResponseDto;
import mi.matveev.domain.db.RunEntity;
import mi.matveev.domain.enumeration.RunStatus;
import mi.matveev.repository.RunRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RunService {
    private final RunRepository runRepository;

    public String createRun(CreateRunRequestDto request) {
        RunEntity run = RunEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .tags(request.getTags())
                .status(RunStatus.IN_PROGRESS)
                .timeCreated(LocalDateTime.now())
                .timeFinished(null)
                .build();

        return runRepository.save(run).getId();
    }

    public GetRunResponseDto getRunById(String runId) {
        RunEntity run = runRepository.getById(runId);

        return GetRunResponseDto.builder()
                .id(run.getId())
                .name(run.getName())
                .tags(run.getTags())
                .status(run.getStatus())
                .timeCreated(run.getTimeCreated())
                .timeFinished(run.getTimeFinished())
                .build();
    }
}

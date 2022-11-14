package mi.matveev.service.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.entity.ScenarioStepsEntity;
import mi.matveev.domain.entity.StepEntity;
import mi.matveev.domain.enumeration.StepStatus;
import mi.matveev.repository.ScenarioStepsRepository;
import mi.matveev.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StepService {
    private final StepRepository stepRepository;
    private final ScenarioStepsRepository scenarioStepsRepository;

    public String createStep(String scenarioId, StepEntity step) {
        String stepId = UUID.randomUUID().toString();
        step = step.toBuilder()
                .id(stepId)
                .status(StepStatus.IN_PROGRESS)
                .timeCreated(LocalDateTime.now())
                .timeFinished(null)
                .build();
        stepRepository.save(step);

        ScenarioStepsEntity scenarioStepsEntity = ScenarioStepsEntity.builder()
                .id(UUID.randomUUID().toString())
                .scenarioId(scenarioId)
                .stepId(stepId)
                .build();
        scenarioStepsRepository.save(scenarioStepsEntity);

        return stepId;
    }

    public Void finishStep(String stepId, StepStatus status) {
        StepEntity step = stepRepository.findById(stepId)
                .orElseThrow(() -> new NullPointerException("Step with id - '" + stepId + "' not found"))
                .toBuilder()
                .status(status)
                .timeFinished(LocalDateTime.now())
                .build();
        stepRepository.save(step);

        return null;
    }
}

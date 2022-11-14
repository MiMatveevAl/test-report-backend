package mi.matveev.service.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.entity.RunScenariosEntity;
import mi.matveev.domain.entity.ScenarioEntity;
import mi.matveev.domain.enumeration.ScenarioStatus;
import mi.matveev.repository.RunScenariosRepository;
import mi.matveev.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScenarioService {
    private final RunScenariosRepository runScenariosRepository;
    private final ScenarioRepository scenarioRepository;

    public String createScenario(String runId, ScenarioEntity scenario) {
        String scenarioId = UUID.randomUUID().toString();
        scenario = scenario.toBuilder()
                .id(scenarioId)
                .status(ScenarioStatus.IN_PROGRESS)
                .timeCreated(LocalDateTime.now())
                .timeFinished(null)
                .build();
        scenarioRepository.save(scenario);

        RunScenariosEntity runScenariosEntity = RunScenariosEntity.builder()
                .id(UUID.randomUUID().toString())
                .runId(runId)
                .scenarioId(scenarioId)
                .build();
        runScenariosRepository.save(runScenariosEntity);

        return scenarioId;
    }

    public Void finishScenario(String scenarioId, ScenarioStatus status) {
        ScenarioEntity scenario = scenarioRepository.findById(scenarioId)
                .orElseThrow(() -> new NullPointerException("Scenario with id - '" + scenarioId + "' not found"))
                .toBuilder()
                .status(status)
                .timeFinished(LocalDateTime.now())
                .build();
        scenarioRepository.save(scenario);

        return null;
    }
}

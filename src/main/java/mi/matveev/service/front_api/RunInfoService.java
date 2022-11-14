package mi.matveev.service.front_api;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.dto.RunInfoDto;
import mi.matveev.domain.dto.ScenarioInfoDto;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.domain.entity.RunScenariosEntity;
import mi.matveev.domain.entity.ScenarioEntity;
import mi.matveev.repository.RunRepository;
import mi.matveev.repository.RunScenariosRepository;
import mi.matveev.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RunInfoService {
    private final RunRepository runRepository;
    private final RunScenariosRepository runScenariosRepository;
    private final ScenarioRepository scenarioRepository;

    public RunInfoDto getRunInfoById(String runId) {
        RunEntity run = runRepository.findById(runId)
                .orElseThrow(() -> new NullPointerException("Run with id - '" + runId + "' not found"));

        List<String> scenarioIds = runScenariosRepository.findByRunId(runId)
                .stream()
                .map(RunScenariosEntity::getScenarioId)
                .collect(Collectors.toList());
        List<ScenarioEntity> scenarios = scenarioRepository.findAllById(scenarioIds);

        return RunInfoDto.builder()
                .id(run.getId())
                .name(run.getName())
                .tags(run.getTags())
                .timeCreated(run.getTimeCreated())
                .scenarios(generateScenariosInfo(scenarios))
                .build();
    }

    private List<ScenarioInfoDto> generateScenariosInfo(List<ScenarioEntity> scenarios) {
        return scenarios.stream()
                .map(scenario -> ScenarioInfoDto.builder()
                        .id(scenario.getId())
                        .name(scenario.getName())
                        .tags(scenario.getTags())
                        .status(scenario.getStatus())
                        .timeCreated(scenario.getTimeCreated())
                        .timeFinished(scenario.getTimeFinished())
                        .build()
                )
                .collect(Collectors.toList());
    }
}

package mi.matveev.service.front_api;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.dto.RunInfoDto;
import mi.matveev.domain.dto.ScenarioInfoDto;
import mi.matveev.domain.dto.StepInfoDto;
import mi.matveev.domain.entity.ProjectEntity;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.domain.entity.RunScenariosEntity;
import mi.matveev.domain.entity.ScenarioStepsEntity;
import mi.matveev.repository.ProjectRepository;
import mi.matveev.repository.RunRepository;
import mi.matveev.repository.RunScenariosRepository;
import mi.matveev.repository.ScenarioRepository;
import mi.matveev.repository.ScenarioStepsRepository;
import mi.matveev.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RunInfoService {
    private final RunRepository runRepository;

    private final RunScenariosRepository runScenariosRepository;
    private final ScenarioRepository scenarioRepository;

    private final ScenarioStepsRepository scenarioStepsRepository;
    private final StepRepository stepRepository;

    private final ProjectRepository projectRepository;

    public RunInfoDto getRunInfoById(String runId) {
        RunEntity run = runRepository.findById(runId)
                .orElseThrow(() -> new NullPointerException("Run with id - '" + runId + "' not found"));

        return RunInfoDto.builder()
                .id(runId)
                .name(run.getName())
                .tags(run.getTags())
                .timeCreated(run.getTimeCreated())
                .scenarios(getRunScenarios(runId))
                .build();
    }

    public List<RunInfoDto> getRunsByProjectId(String projectId) {
        String projectName = projectRepository.findById(projectId)
                .map(ProjectEntity::getName)
                .orElseThrow(() -> new NullPointerException("Project with id - '" + projectId + "' not found"));

        return runRepository.findAllByProject(projectName)
                .stream()
                .map(run -> RunInfoDto.builder()
                        .id(run.getId())
                        .name(run.getName())
                        .tags(run.getTags())
                        .status(run.getStatus())
                        .timeCreated(run.getTimeCreated())
                        .timeFinished(run.getTimeFinished())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ScenarioInfoDto> getRunScenarios(String runId) {
        List<String> scenarioIds = runScenariosRepository.findByRunId(runId)
                .stream()
                .map(RunScenariosEntity::getScenarioId)
                .collect(Collectors.toList());

        return scenarioRepository.findAllById(scenarioIds)
                .stream()
                .map(scenario -> ScenarioInfoDto.builder()
                        .id(scenario.getId())
                        .name(scenario.getName())
                        .tags(scenario.getTags())
                        .status(scenario.getStatus())
                        .timeCreated(scenario.getTimeCreated())
                        .timeFinished(scenario.getTimeFinished())
                        .build())
                .collect(Collectors.toList());
    }

    public List<StepInfoDto> getScenarioSteps(String scenarioId) {
        List<String> stepIds = scenarioStepsRepository.findByScenarioId(scenarioId)
                .stream()
                .map(ScenarioStepsEntity::getStepId)
                .collect(Collectors.toList());

        return stepRepository.findAllById(stepIds)
                .stream()
                .map(step -> StepInfoDto.builder()
                        .id(step.getId())
                        .name(step.getName())
                        .argument(step.getArgument())
                        .type(step.getType())
                        .status(step.getStatus())
                        .timeCreated(step.getTimeCreated())
                        .timeFinished(step.getTimeFinished())
                        // TODO: .logs(null)
                        .build())
                .collect(Collectors.toList());
    }
}

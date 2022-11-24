package mi.matveev.controller.front_api;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.service.front_api.RunInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScenarioInfoController extends AbstractController {
    private final RunInfoService runInfoService;

    @GetMapping("/run/{runId}/scenarios")
    public ResponseEntity<?> getRunScenarios(@PathVariable("runId") String runId) {
        return process(() -> runInfoService.getRunScenarios(runId));
    }

    @GetMapping("/scenario/{scenarioId}/steps")
    public ResponseEntity<?> getScenarioSteps(@PathVariable("scenarioId") String scenarioId) {
        return process(() -> runInfoService.getScenarioSteps(scenarioId));
    }
}

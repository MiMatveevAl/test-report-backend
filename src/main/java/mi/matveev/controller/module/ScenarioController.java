package mi.matveev.controller.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.domain.entity.ScenarioEntity;
import mi.matveev.domain.enumeration.ScenarioStatus;
import mi.matveev.service.module.ScenarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScenarioController extends AbstractController {
    private final ScenarioService scenarioService;

    @PostMapping("/scenario")
    public ResponseEntity<?> createScenario(@RequestParam("runId") String runId,
                                            @RequestBody ScenarioEntity body) {
        return process(() -> scenarioService.createScenario(runId, body));
    }

    @PutMapping("/scenario/{scenarioId}")
    public ResponseEntity<?> finishScenario(@PathVariable("scenarioId") String scenarioId,
                                            @RequestParam("status") ScenarioStatus status) {
        return process(() -> scenarioService.finishScenario(scenarioId, status));
    }
}


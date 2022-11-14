package mi.matveev.controller.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.domain.entity.StepEntity;
import mi.matveev.domain.enumeration.StepStatus;
import mi.matveev.service.module.StepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StepController extends AbstractController {
    private final StepService stepService;

    @PostMapping("/step")
    public ResponseEntity<?> createStep(@RequestParam("scenarioId") String scenarioId,
                                        @RequestBody StepEntity body) {
        return process(() -> stepService.createStep(scenarioId, body));
    }

    @PostMapping("/step/{stepId}")
    public ResponseEntity<?> finishStep(@PathVariable("stepId") String stepId,
                                        @RequestParam("status") StepStatus status) {
        return process(() -> stepService.finishStep(stepId, status));
    }
}

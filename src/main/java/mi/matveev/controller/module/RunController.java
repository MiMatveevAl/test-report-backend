package mi.matveev.controller.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.domain.enumeration.RunStatus;
import mi.matveev.service.module.RunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RunController extends AbstractController {
    private final RunService runService;

    @PostMapping("/run")
    public ResponseEntity<?> createRun(@RequestBody RunEntity body) {
        return process(() -> runService.createRun(body));
    }

    @PutMapping("/run/{runId}")
    public ResponseEntity<?> finishRun(@PathVariable("runId") String runId,
                                       @RequestParam("status") RunStatus status) {
        return process(() -> runService.finishRun(runId, status));
    }
}

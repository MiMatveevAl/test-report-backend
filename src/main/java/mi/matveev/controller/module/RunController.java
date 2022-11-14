package mi.matveev.controller.module;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.domain.entity.RunEntity;
import mi.matveev.service.module.RunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RunController extends AbstractController {
    private final RunService runService;

    @PostMapping("/run")
    public ResponseEntity<?> createRun(@RequestBody RunEntity body) {
        return process(() -> runService.createRun(body));
    }
}

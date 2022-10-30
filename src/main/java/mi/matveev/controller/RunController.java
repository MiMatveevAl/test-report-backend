package mi.matveev.controller;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.api.CreateRunRequestDto;
import mi.matveev.service.RunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RunController extends AbstractController {
    private final RunService runService;

    @PostMapping("/run")
    public ResponseEntity<?> createRun(@RequestBody CreateRunRequestDto body) {
        return process(() -> runService.createRun(body));
    }

    @GetMapping("/run/{id}")
    public ResponseEntity<?> getRunById(@PathVariable("id") String id) {
        return process(() -> runService.getRunById(id));
    }
}

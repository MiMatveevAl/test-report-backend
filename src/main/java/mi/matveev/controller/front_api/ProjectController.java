package mi.matveev.controller.front_api;

import lombok.RequiredArgsConstructor;
import mi.matveev.controller.AbstractController;
import mi.matveev.domain.entity.ProjectEntity;
import mi.matveev.service.front_api.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController extends AbstractController {
    private final ProjectService projectService;

    @PostMapping("/project")
    public ResponseEntity<?> createProject(@RequestBody ProjectEntity body) {
        return process(() -> projectService.createProject(body));
    }

    @GetMapping("/project")
    public ResponseEntity<?> getProjects() {
        return process(projectService::getProjects);
    }
}

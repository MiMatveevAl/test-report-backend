package mi.matveev.service.front_api;

import lombok.RequiredArgsConstructor;
import mi.matveev.domain.entity.ProjectEntity;
import mi.matveev.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Void createProject(ProjectEntity project) {
        if (project.getName() == null || project.getName().isEmpty()) {
            throw new IllegalArgumentException("Name must is not empty");
        }
        projectRepository.findByName(project.getName())
                .ifPresent(proj -> {
                    throw new IllegalArgumentException("Project with name '" + proj.getName() + "' exists");
                });
        project = project.toBuilder()
                .id(UUID.randomUUID().toString())
                .build();
        projectRepository.save(project);

        return null;
    }

    public List<ProjectEntity> getProjects() {
        return projectRepository.findAll();
    }
}

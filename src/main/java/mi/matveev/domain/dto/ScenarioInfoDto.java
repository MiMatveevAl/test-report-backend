package mi.matveev.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mi.matveev.domain.enumeration.ScenarioStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ScenarioInfoDto {
    private String id;
    private String name;
    private String tags;
    private ScenarioStatus status;
    private LocalDateTime timeCreated;
    private LocalDateTime timeFinished;
    private List<StepInfoDto> steps;
}

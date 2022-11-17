package mi.matveev.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mi.matveev.domain.enumeration.StepStatus;
import mi.matveev.domain.enumeration.StepType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class StepInfoDto {
    private String id;
    private String name;
    private String argument;
    private StepType type;
    private StepStatus status;
    private LocalDateTime timeCreated;
    private LocalDateTime timeFinished;
    private List<LogInfoDto> logs;
}

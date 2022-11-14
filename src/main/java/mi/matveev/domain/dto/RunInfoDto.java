package mi.matveev.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class RunInfoDto {
    private String id;
    private String name;
    private String tags;
    private LocalDateTime timeCreated;
    private List<ScenarioInfoDto> scenarios;
}

package mi.matveev.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class StepInfoDto {
    private String id;
    private List<LogInfoDto> logs;
}

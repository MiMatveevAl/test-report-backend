package mi.matveev.domain.api;

import lombok.Builder;
import lombok.Data;
import mi.matveev.domain.enumeration.RunStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class GetRunResponseDto {
    private String id;
    private String name;
    private String tags;
    private RunStatus status;
    private LocalDateTime timeCreated;
    private LocalDateTime timeFinished;
}

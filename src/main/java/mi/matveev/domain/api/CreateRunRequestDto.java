package mi.matveev.domain.api;

import lombok.Data;

@Data
public class CreateRunRequestDto {
    private String name;
    private String tags;
    private String project;
}

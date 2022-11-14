package mi.matveev.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mi.matveev.domain.enumeration.ScenarioStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "SCENARIO")
public class ScenarioEntity {
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "PATH")
    private String path;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private ScenarioStatus status;

    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @Column(name = "TIME_FINISHED")
    private LocalDateTime timeFinished;
}



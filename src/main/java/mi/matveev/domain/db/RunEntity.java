package mi.matveev.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mi.matveev.domain.enumeration.RunStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "run")
public class RunEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "tags")
    private String tags;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private RunStatus status;

    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Column(name = "time_finished")
    private LocalDateTime timeFinished;
}

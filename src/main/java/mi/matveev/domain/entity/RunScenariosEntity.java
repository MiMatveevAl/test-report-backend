package mi.matveev.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "RUN_SCENARIOS")
public class RunScenariosEntity {
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "RUN_ID", length = 36)
    private String runId;

    @Column(name = "SCENARIO_ID", length = 36)
    private String scenarioId;
}

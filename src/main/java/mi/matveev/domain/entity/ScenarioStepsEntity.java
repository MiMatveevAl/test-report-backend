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
@Table(name = "SCENARIO_STEPS")
public class ScenarioStepsEntity {
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "SCENARIO_ID", length = 36)
    private String scenarioId;

    @Column(name = "STEP_ID", length = 36)
    private String stepId;
}

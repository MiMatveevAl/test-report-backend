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
@Table(name = "PROJECT")
public class ProjectEntity {
    @Id
    @Column(name = "ID", length = 36)
    private String id;

    @Column(name = "NAME")
    private String name;
}

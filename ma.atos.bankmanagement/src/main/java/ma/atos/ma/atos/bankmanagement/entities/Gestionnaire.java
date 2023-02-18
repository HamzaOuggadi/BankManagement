package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "Gestionnaire",uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numGestionnaire"})}
)
public class Gestionnaire {
    @Column(name = "idGestionnaire")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestionnaire ;
    @Column(name = "numGestionnaire")
    private String numGestionnaire;

}

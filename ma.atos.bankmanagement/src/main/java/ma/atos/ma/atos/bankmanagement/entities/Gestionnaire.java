package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Gestionnaire",uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numGestionnaire"})}
)
public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestionnaire;
    private String numGestionnaire;
    private String nom;
    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.REMOVE)
    private List<Compte> comptes;
}

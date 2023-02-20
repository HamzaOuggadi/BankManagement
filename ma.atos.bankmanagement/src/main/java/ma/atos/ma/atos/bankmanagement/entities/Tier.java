package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIER_TYPE")
@Table(name = "Tier", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numClient"})})
public abstract class Tier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idClient;
    private String numClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;
    @OneToMany
    protected List<Compte> comptes;
    @OneToMany
    protected List<Restriction> restrictions;

}

package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIER_TYPE")
public abstract class Tier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;

}

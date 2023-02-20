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
    @Column(name = "nationalite")
    protected String nationalite;
    @Column(name= "dateSouscription")
    protected Date dateSouscription;
    @Column(name = "adresse")
    protected String adresse;

}

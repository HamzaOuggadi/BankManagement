package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Restriction")

public class Restriction {
    @Column(name = "idRestriction")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestriction;
    @Column(name = "etat")
    private String etat;
}

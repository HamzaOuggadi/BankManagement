package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Agence", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"codeAgence"})})
public class Agence {

    @Column(name = "idAgence")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(name = "codeAgence")
    private String codeAgence;
    @Column(name = "nomAgence")
    private String nomAgence;
    @Column(name = "adressAgence")
    private String adressAgence;

}

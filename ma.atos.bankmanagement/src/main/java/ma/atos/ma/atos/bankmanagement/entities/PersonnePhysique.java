package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
@Data
@Entity
@Table(name = "PersonnePhysique" ,
        uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numTel","email"})}
)
public class PersonnePhysique extends Tier{
    @Column(name = "nomComplet")
    private String nomComplet ;
    @Column(name = "dateNaissance")
    private Date dateNaissance;
    @Column(name = "typeIdentification")
    private String typeIdentification;
    @Column(name = "numTel")
    private String numTel;
    @Column(name = "email")
    private String email;

}

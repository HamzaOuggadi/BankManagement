package ma.atos.ma.atos.bankmanagement.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PersonnePhysique" ,
        uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numTel","email"})})
@DiscriminatorValue("PP")
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

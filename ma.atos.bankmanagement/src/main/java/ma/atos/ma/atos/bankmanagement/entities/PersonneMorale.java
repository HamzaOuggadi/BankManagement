package ma.atos.ma.atos.bankmanagement.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "PersonneMorale", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numRegisterCom"})})
@DiscriminatorValue("PM")
public class PersonneMorale extends Tier{

    @Column(name = "raionSociale")
    private String raionSociale;
    @Column(name = "numRegisterCom")
    private String numRegisterComm;

}

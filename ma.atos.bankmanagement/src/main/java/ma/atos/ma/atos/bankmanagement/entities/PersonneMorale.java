package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PersonneMorale", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numRegisterCom"})})
@DiscriminatorValue("PM")
public class PersonneMorale extends Tier{

    private String raionSociale;
    private String numRegisterComm;

}

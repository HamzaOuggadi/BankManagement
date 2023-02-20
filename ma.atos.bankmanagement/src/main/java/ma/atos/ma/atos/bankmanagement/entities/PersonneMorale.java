package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "PersonneMorale", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numRegisterCom"})})
@DiscriminatorValue("PM")
public class PersonneMorale extends Tier{

    private String raionSociale;
    private String numRegisterComm;

}

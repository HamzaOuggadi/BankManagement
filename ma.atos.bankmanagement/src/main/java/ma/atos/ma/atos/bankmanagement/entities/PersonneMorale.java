package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Table(name = "PersonneMorale", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numRegisterCom"})})
public class PersonneMorale extends Tier{

    @Column(name = "raionSociale")
    private String raionSociale;
    @Column(name = "numRegisterCom")
    private String numRegisterComm;

}

package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "Tier", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"idClient"})})

public  abstract class Tier {
    @Column(name = "idClient")
    @Id
    protected Long idClient;
    @Column(name = "nationalite")
    protected String nationalite;
    @Column(name = "dateSouscription")
    protected Date dateSouscription ;
    @Column(name = "adresse")
    protected String adresse;

}

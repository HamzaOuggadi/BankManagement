package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;
// POJO
@Data
@Entity
@Table(name = "Compte", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"ribCompte"})})

public class Compte {
    @Column(name = "idCompte")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    @Column(name = "ribCompte")
    private Long ribCompte;
    @Column(name = "typeCompte")
    private TypeCompte typeCompte;
    @Column(name = "balance")
    private double balance;
    @Column(name = "dateCreation")
    private Date dateCreation;
    @Column(name = "devise")
    private String devise;

}

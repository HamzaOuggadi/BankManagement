package ma.atos.ma.atos.bankmanagement.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "Compte", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"ribCompte"})})
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private Long ribCompte;
    private TypeCompte typeCompte;
    private double balance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;
    private String devise;
    @ManyToOne
    private Tier tier;
    @ManyToOne
    private Gestionnaire gestionnaire;
    @OneToMany
    private List<Sitex> sitexes;
    @OneToMany
    private List<Operation> operations;

}

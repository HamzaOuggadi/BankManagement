package ma.atos.ma.atos.bankmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.enums.SensOperation;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)

public class VirementDto {

    private double montant;
    private String description;
    private Date dateOperation;
    private SensOperation sensOperation;

//    private String typeOperation;

//    @JsonIgnore
//    private Long idCompte;


    private Long ribCompte;

    private String ribCompteDestinataire;

    public Long getRibCompte() {
        return ribCompte;
    }

    public void setRibCompte(Long ribCompte) {
        this.ribCompte = ribCompte;
    }


}

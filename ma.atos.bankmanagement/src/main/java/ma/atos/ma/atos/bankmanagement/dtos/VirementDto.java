package ma.atos.ma.atos.bankmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)

public class VirementDto extends OperationDto {

//    private double montant;
//    private String description;
//    private Date dateOperation;
//    private SensOperation sensOperation;

//    private String typeOperation;

//    @JsonIgnore
    private Long idCompte;

//    @JsonIgnore
    private Long ribCompte;

    @JsonIgnore
    public Long getRibCompte() {
        return ribCompte;
    }

    private Long ribCompteDestinataire;

    public Long getRibCompteDestinataire() {
        return ribCompteDestinataire;
    }

}

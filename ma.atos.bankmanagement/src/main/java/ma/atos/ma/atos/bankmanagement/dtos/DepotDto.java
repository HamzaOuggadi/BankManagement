package ma.atos.ma.atos.bankmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;

@Data
public class DepotDto extends OperationDto{

//    private double montant;
//    private String description;
//    private Date dateOperation;
//    private SensOperation sensOperation;
//  private String typeOperation;
//    @JsonIgnore
    private Long idCompte;
    private Long ribCompte;
    private SourceDepot sourceDepot;


//    public Long getRibCompte() {
//        return ribCompte;
//    }

//    public void setRibCompte(Long ribCompte) {
//        this.ribCompte = ribCompte;
//    }


    @JsonIgnore
    public Long getRibCompte() {
        return ribCompte;
    }

}



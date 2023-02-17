package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonnePhysiqueDto extends TierDto {
    private String nomCompet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}

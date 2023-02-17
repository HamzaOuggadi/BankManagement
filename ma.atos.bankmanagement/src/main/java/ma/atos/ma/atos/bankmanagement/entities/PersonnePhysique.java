package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonnePhysique extends Tier{
    private String nomCompet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}

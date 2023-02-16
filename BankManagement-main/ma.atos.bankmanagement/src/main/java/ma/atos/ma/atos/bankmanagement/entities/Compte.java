package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compte {
    private Long idCompte;
    private Long ribCompte;
    private String typeCompte;
    private  double balance;
    private Date dateCreation;
    private String devise;

}

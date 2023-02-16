package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public  abstract class Tier {
     private Long idClient;
    private String nationalite;
    private Date dateSouscription ;
    private String adresse;

}

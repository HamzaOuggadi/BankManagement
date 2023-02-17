package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public  abstract class Tier {
     protected Long idClient;
    protected String nationalite;
    protected Date dateSouscription ;
    protected String adresse;

}

package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public  abstract class TierDto {

    protected String nationalite;
    protected Date dateSouscription ;
    protected String adresse;

}

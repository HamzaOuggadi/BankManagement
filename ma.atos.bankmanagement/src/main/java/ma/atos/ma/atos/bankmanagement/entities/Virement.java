package ma.atos.ma.atos.bankmanagement.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation{

    private String ribDestinataire;

}

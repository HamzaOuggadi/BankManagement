package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.Data;
import ma.atos.ma.atos.bankmanagement.entities.Operation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class VirementDto extends Operation {

    private String ribDestinataire;

}

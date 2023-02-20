package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.Data;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class DepotDto extends Operation {

    private SourceDepot sourceDepot;
}

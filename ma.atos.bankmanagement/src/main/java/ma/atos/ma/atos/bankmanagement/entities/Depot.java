package ma.atos.ma.atos.bankmanagement.entities;

import lombok.Data;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("DEPOT")
public class Depot extends Operation{

    private SourceDepot sourceDepot;
}

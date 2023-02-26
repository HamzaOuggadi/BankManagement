package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("depot")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "depot" )

public class Depot extends Operation{

    protected SourceDepot sourceDepot;

}



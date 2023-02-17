package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Operation {
    protected Long idOperation;
    protected double montant;
    protected String description;
    protected Date dateOperation;
}

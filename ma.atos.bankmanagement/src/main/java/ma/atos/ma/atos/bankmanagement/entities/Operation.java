package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Operation {
    private Long idOperation;
    private double montant;
    private String description;
    private Date dateOperation;
}

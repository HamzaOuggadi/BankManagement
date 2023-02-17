package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="Operation",uniqueConstraints = {
        @UniqueConstraint( columnNames = {"idOperation"})
}
        )

public abstract class Operation {
    @Column(name = "idOperation")
    @Id
    protected Long idOperation;
    @Column(name = "montant")
    protected double montant;
    @Column(name="description")
    protected String description;
    @Column(name="dateOperation")
    protected Date dateOperation;
}

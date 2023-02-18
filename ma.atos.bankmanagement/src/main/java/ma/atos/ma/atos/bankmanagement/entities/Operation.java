package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="Operation")


public abstract class Operation {
    @Column(name = "idOperation")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idOperation;
    @Column(name = "montant")
    protected double montant;
    @Column(name="description")
    protected String description;
    @Column(name="dateOperation")
    protected Date dateOperation;
}

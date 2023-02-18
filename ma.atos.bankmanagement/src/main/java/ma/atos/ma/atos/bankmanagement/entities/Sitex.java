package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Sitex" )
public class Sitex {
    @Column(name = "idSitex")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitex;
    @Column(name = "type")
    private String type;
}

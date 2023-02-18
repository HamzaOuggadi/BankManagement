package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

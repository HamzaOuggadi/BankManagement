package ma.atos.ma.atos.bankmanagement.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Restriction")
public class Restriction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestriction;
    private String etat;

   @ManyToOne
   @JsonIgnore
   private Tier tier;


}

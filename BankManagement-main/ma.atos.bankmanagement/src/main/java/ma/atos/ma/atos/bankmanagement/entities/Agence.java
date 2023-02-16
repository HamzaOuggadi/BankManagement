package ma.atos.ma.atos.bankmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Agence {
    private Long idAgence;
    private String nomAgence;
    private String adresseAgence;
}

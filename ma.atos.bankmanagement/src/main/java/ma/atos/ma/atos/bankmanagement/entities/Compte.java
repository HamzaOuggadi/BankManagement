package ma.atos.ma.atos.bankmanagement.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Compte {

    private Long idCompte;
    private Long ribCompte;
    private Double balance;
    private Date dateCreation;
    private String devise;

    //typeCompte
}

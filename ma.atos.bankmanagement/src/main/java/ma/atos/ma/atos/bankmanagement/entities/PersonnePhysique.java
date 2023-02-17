package ma.atos.ma.atos.bankmanagement.entities;

import lombok.Data;

import java.util.Date;

public class PersonnePhysique extends Tier{
    private String nomCompet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}

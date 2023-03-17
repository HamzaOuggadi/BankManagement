package ma.atos.ma.atos.bankmanagement.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class PersonnePhysiqueDto   {

    private String numClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;
    protected List<CompteDto> comptes;
    protected List<RestrictionDto> restrictions;
    private String nomCompet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}

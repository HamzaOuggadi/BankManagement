package ma.atos.ma.atos.bankmanagement.dtos;

import lombok.Data;

import java.util.Date;

@Data

public class PersonneMoraleDto  {

    private String numClient;
    private String nationalite;
    private Date dateSouscription;
    private String adresse;
    private String raionSociale;
    private String numRegisterComm;

}

package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Agence;
import ma.atos.ma.atos.bankmanagement.entities.Compte;

public interface CompteMapper {

    CompteDto compteToCompteDto(Compte compte);


}



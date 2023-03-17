package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CompteMapper {

    CompteDto compteToCompteDto(Compte compte);

    Compte compteDtoToCompte(CompteDto compteDto);

}



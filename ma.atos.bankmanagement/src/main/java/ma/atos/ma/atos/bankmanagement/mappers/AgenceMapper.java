package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.entities.Agence;
import org.mapstruct.Mapper;

@Mapper
public interface AgenceMapper {

        AgenceDto agenceToAgenceDto(Agence agence);



}

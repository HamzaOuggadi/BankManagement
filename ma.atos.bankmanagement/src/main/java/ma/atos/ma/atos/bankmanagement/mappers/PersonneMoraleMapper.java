package ma.atos.ma.atos.bankmanagement.mappers;


import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMoraleMapper {

    PersonneMoraleDto personneToPersonneDto(PersonneMorale personneMorale);
    PersonneMorale PmDtoToPm(PersonneMoraleDto personneMoraleDto);
}

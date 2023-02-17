package ma.atos.ma.atos.bankmanagement.mappers;


import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import org.mapstruct.Mapper;

@Mapper
public interface PersonneMoraleMapper {

    PersonneMoraleDto personneToPersonneDto(PersonneMoraleMapper personne);
}

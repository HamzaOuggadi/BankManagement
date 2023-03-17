package ma.atos.ma.atos.bankmanagement.mappers;
import ma.atos.ma.atos.bankmanagement.dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PersonneMoraleMapper {

    PersonneMoraleDto personneToPersonneDto(PersonneMoraleMapper personne);

    PersonneMoraleDto personneToPersonneDto(PersonneMorale personneMorale);
    PersonneMorale PmDtoToPm(PersonneMoraleDto personneMoraleDto);


}

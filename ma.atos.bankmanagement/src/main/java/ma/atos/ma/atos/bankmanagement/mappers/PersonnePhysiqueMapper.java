package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import org.mapstruct.Mapper;


@Mapper
public interface PersonnePhysiqueMapper {

    PersonnePhysiqueDto personnePhysiqueToPersonnePhysiqueDto(PersonnePhysique personnePhysique);

    PersonnePhysique PpDtoToPp(PersonnePhysiqueDto personnePhysiqueDto);
}

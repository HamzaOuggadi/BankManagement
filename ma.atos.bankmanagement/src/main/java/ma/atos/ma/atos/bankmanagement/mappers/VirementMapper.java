package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.entities.Virement;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface VirementMapper {

    VirementDto virementToVirementDto(Virement virement);

    Virement virementDtoToVirement(VirementDto virementDto);


}

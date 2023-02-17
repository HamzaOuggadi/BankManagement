package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import org.mapstruct.Mapper;


@Mapper
public interface SitexMapper {

    AgenceDto operationToOperationDto(Operation operation);

}

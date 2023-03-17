package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OperationMapper
{
    public Operation toEntity(OperationDto operationDto);


    OperationDto toDto(Operation operation);
}




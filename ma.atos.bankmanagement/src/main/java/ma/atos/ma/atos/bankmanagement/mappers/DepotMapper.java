package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.entities.Depot;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DepotMapper {

    DepotDto depotToDepotDto(Depot depot);

    Depot depotDtoToDepot(DepotDto depotDto);


}

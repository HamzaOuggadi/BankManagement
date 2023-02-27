package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;

import java.util.List;

public interface OperationService {

    List<OperationDto> getAllOperations();

    List<OperationDto> getOperationsByRibCompte(Long ribCompte);

    List<OperationDto> getOperationsByTypeOperation(String typeOperation);

    OperationDto getOperationById(Long id);

    public VirementDto createVirement(VirementDto virementDto);

    public DepotDto createDepot(DepotDto depotDto);

    // Version 2 to creat operation with OperaionDto
    OperationDto createOperation(OperationDto operationDto);






}

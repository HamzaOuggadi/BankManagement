package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;

import java.util.List;

public interface OperationService {

    OperationDto createOperation(OperationDto operationDto);

    List<OperationDto> getAllOperations();
    List<OperationDto> getOperationsByCriteria(Long ribCompte, String typeOperation);

    List<OperationDto> getOperationsByRibCompte(Long ribCompte);

    List<OperationDto> getOperationsByTypeOperation(String typeOperation);

    OperationDto getOperationById(Long id);

}

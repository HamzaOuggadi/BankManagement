package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import java.util.List;

public interface OperationService {

    //List Operation
    List<OperationDto> getAllOperations();

    //List Operation by Compte
    List<OperationDto> getOperationsByCompte(Long id);

    //Create Operation
    OperationDto createOperation(OperationDto operationDto);

    //Get Operation by Id
    OperationDto getOperationById(Long id);

}

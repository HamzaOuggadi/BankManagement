package ma.atos.ma.atos.bankmanagement.web;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<List<OperationDto>> getAllOperations() {
        List<OperationDto> operations = operationService.getAllOperations();
        if (operations == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(operations);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationDto> getOperationById(@PathVariable Long id) {
        OperationDto operation = operationService.getOperationById(id);

        if (operation == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(operation);

        }
    }

    @GetMapping("/type/{typeOperation}")
    public ResponseEntity<List<OperationDto>> getOperationsByTypeOperation(
            @PathVariable String typeOperation) {
        List<OperationDto> operations = operationService.getOperationsByTypeOperation(typeOperation);
        if (operations == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operations);
    }

    @PostMapping
    public ResponseEntity<OperationDto> createOperation(@RequestBody OperationDto operationDto) {
        OperationDto createdOperation = operationService.createOperation(operationDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdOperation);
    }

    @PostMapping("/saveVirement")
    @ResponseBody
    public VirementDto saveVirement(@RequestBody VirementDto request) {
        return operationService.createVirement(request);
    }

    @PostMapping("/saveDepot")
    @ResponseBody
    public DepotDto saveDepot(@RequestBody DepotDto request) {
        return operationService.createDepot(request);
    }


    @GetMapping("/getOperations/{ribCompte}")
    public ResponseEntity<List<OperationDto>> getOperationsByRibCompte(@PathVariable Long ribCompte) {
        List<OperationDto> operationDtos = operationService.getOperationsByRibCompte(ribCompte);
        if (operationDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operationDtos);
    }
}







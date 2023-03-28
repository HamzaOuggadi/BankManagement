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

import java.util.HashMap;
import java.util.List;

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
import java.util.Map;

@RestController
@RequestMapping("/operations")
@CrossOrigin(origins = "localhost:4200", allowedHeaders = "*")

public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/getByCretiria")
    public ResponseEntity<List<OperationDto>> getOperationsByCriteria(
            @RequestParam(required = false) Long ribCompte,
            @RequestParam(required = false) String typeOperation) {
        List<OperationDto> operations = operationService.getOperationsByCriteria(ribCompte, typeOperation);
        if (operations == null || operations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operations);
    }

    @GetMapping("/list")
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


    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createOperation(@RequestBody OperationDto operationDto) {
        OperationDto createdOperation = operationService.createOperation(operationDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Operation created successfully");
        response.put("operationId", createdOperation.getIdOperation());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }





}







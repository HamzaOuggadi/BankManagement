package ma.atos.ma.atos.bankmanagement.web;


import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.AgenceException;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.repositories.AgenceRepository;
import ma.atos.ma.atos.bankmanagement.services.impl.AgenceServiceImp;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/agency")
@AllArgsConstructor
public class AgenceController {

    private final AgenceRepository agenceRepository;
    private final AgenceServiceImp agenceServiceImp;
    private final MessageSource messageSource;

    @GetMapping("/list")
    public List<AgenceDto> agences() throws AgenceException{
        return agenceServiceImp.listAgences();
    }
    @GetMapping("/get/{codeAgence}")
    public ResponseEntity<AgenceDto> getAgence(@PathVariable String codeAgence) throws AgenceException {
        return ResponseEntity.ok(agenceServiceImp.getAgence(codeAgence));
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createAgence(@RequestBody AgenceDto agenceDto) throws AgenceException {
        GenericResponse result = new GenericResponse();
        agenceServiceImp.createAgence(agenceDto);

        result.setDescription(messageSource.getMessage("agence.created.success", new Object[] {agenceDto.getCodeAgence()}, Locale.getDefault()));

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{codeAgence}")
    public ResponseEntity<GenResponse> deleteAccount(@PathVariable String codeAgence) throws AgenceException {
        GenResponse response = new GenResponse();
        agenceServiceImp.deleteAgence(codeAgence);
        response.setError(false);
        response.setDescription(messageSource.getMessage("agence.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }


}

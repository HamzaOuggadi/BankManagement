package ma.atos.ma.atos.bankmanagement.web;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.services.CompteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
public class CompteController {
    CompteServiceImpl compteService;
    MessageSource messageSource;

    @GetMapping("/comptes")
    public ResponseEntity<List<CompteDto>> listCompte() throws CompteException {
        return ResponseEntity.ok(compteService.listComptes());
    }
    @GetMapping("/comptes/{ribCompte}")
    public ResponseEntity<CompteDto> getCompte(@PathVariable Long ribCompte) {
        return ResponseEntity.ok(compteService.getCompte(ribCompte));
    }

    @PostMapping("/comptes/createCompte")
    public ResponseEntity<GenericResponse> createCompte(@RequestBody CompteDto compteDto) {
        GenericResponse result = new GenericResponse();
        compteService.createCompte(compteDto);

        result.setDescription(messageSource.getMessage("account.created.success", new Object[] {compteDto.getRibCompte()}, Locale.getDefault()));
        result.setStatusCode(String.valueOf(HttpStatus.OK));

        return ResponseEntity.ok(result);
    }

}

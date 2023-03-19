package ma.atos.ma.atos.bankmanagement.web;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.services.impl.CompteServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/comptes")
@AllArgsConstructor
public class CompteController {

    private final CompteServiceImpl compteService;
    private final MessageSource messageSource;

    @GetMapping()
    public ResponseEntity<List<CompteDto>> listCompte() throws CompteException {
        return ResponseEntity.ok(compteService.listComptes());
    }
    @GetMapping("/{numRib}")
    public ResponseEntity<List<CompteDto>> getCompte(@PathVariable Long numRib) throws CompteException {
        List<CompteDto> compteDtos = new ArrayList<>();
        compteDtos.add(compteService.getCompte(numRib));
        return ResponseEntity.ok(compteDtos);
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createCompte(@RequestBody CompteDto compteDto,
                                                        @RequestParam String numClient,
                                                        @RequestParam Long idGestionnaire) throws CompteException {
        GenericResponse result = new GenericResponse();
        compteService.createCompte(compteDto, numClient, idGestionnaire);
        result.setDescription(messageSource.getMessage("account.created.success", new Object[] {compteDto.getRibCompte()}, Locale.getDefault()));
        result.setStatusCode(String.valueOf(HttpStatus.OK));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteByRib/{ribCompte}")
    public ResponseEntity<GenResponse> deleteAccount(@PathVariable Long ribCompte) throws CompteException {
        GenResponse response = new GenResponse();
        compteService.deleteCompte(ribCompte);
        response.setError(false);
        response.setDescription(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(params = "numClient")
    public ResponseEntity<List<CompteDto>> getCompteByNumClient(@RequestParam String numClient) throws CompteException {
        if (!Objects.equals(numClient, "")) {
            return ResponseEntity.ok(compteService.getCompteByTier(numClient));
        } else {
            return ResponseEntity.ok(compteService.listComptes());
        }
    }
}

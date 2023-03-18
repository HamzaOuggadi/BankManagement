package ma.atos.ma.atos.bankmanagement.web;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.feignproxies.SitexProxy;
import ma.atos.ma.atos.bankmanagement.services.CompteServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CompteController {
    CompteServiceImpl compteService;
    MessageSource messageSource;
    SitexProxy sitexProxy;

    @GetMapping("/comptes")
//    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<CompteDto>> listCompte() throws CompteException {
        return ResponseEntity.ok(compteService.listComptes());
    }
    @GetMapping("/comptes/{ribCompte}")
//    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<CompteDto>> getCompte(@PathVariable Long ribCompte) throws CompteException {
        List<CompteDto> compteDtos = new ArrayList<>();
        compteDtos.add(compteService.getCompte(ribCompte));
        return ResponseEntity.ok(compteDtos);
    }

    @PostMapping("/comptes/createCompte")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<GenericResponse> createCompte(@RequestBody CompteDto compteDto) throws CompteException {
        GenericResponse result = new GenericResponse();
        compteService.createCompte(compteDto);

        result.setDescription(messageSource.getMessage("account.created.success", new Object[] {compteDto.getRibCompte()}, Locale.getDefault()));
        result.setStatusCode(String.valueOf(HttpStatus.OK));

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/comptes/deleteAccount/{ribCompte}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<GenResponse> deleteAccount(@PathVariable Long ribCompte) throws CompteException {
        GenResponse response = new GenResponse();
        compteService.deleteCompte(ribCompte);
        response.setError(false);
        response.setDescription(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }
/*    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = sitexProxy.getPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(sitexProxy.getPostById(id));
    }*/

    @GetMapping("/ComptesDTO")
    public ResponseEntity<List<CompteDto>> getComptesDTO() {
        return ResponseEntity.ok(sitexProxy.getComptes());
    }

    @GetMapping(value = "/comptes", params = "numClient")
    public ResponseEntity<List<CompteDto>> getCompteByNumClient(@RequestParam String numClient) throws CompteException {
        return ResponseEntity.ok(compteService.getCompteByTier(numClient));
    }
}

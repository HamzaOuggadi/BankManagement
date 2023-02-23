package ma.atos.ma.atos.bankmanagement.web;


import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.services.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CompteController {

    CompteService compteService;


    @GetMapping("comptes")
    public ResponseEntity<List<CompteDto>> listComptes() throws CompteException {
        List<CompteDto> compteDtoList = compteService.listComptes();
        return new ResponseEntity<>(compteDtoList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{ribCompte}")
    public ResponseEntity<?> deleteCompte(@PathVariable("ribCompte") Long ribCompte) throws CompteException {
        compteService.deleteCompte(ribCompte);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("comptesByTier/{numClient}")
    public ResponseEntity<List<CompteDto>> listComptesByTier(@PathVariable("numClient") String numClient) throws CompteException {
        List<CompteDto> compteDtoList = compteService.getCompteByTier(numClient);
        return new ResponseEntity<>(compteDtoList, HttpStatus.OK);
    }
}

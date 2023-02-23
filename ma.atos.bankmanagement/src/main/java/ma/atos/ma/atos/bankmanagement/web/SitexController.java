package ma.atos.ma.atos.bankmanagement.web;
import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.entities.Sitex;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;
import ma.atos.ma.atos.bankmanagement.repositories.SitexRepository;
import ma.atos.ma.atos.bankmanagement.services.SitexServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SitexController {
    private SitexRepository sitexRepository;
    private SitexServiceImpl sitexService;

    @GetMapping(path = "/sitex/{idSitex}")
    public SitexDto getSitex(@PathVariable(name = "idSitex") Long idSitex) {
       return sitexService.getSitex(idSitex);
    }
    @GetMapping("/sitex")
    public List<SitexDto> sitexes() throws SitexExeption {
        return sitexService.listSitex();
    }
    @PostMapping("/sitex")
    public void createSitex(@RequestBody SitexDto sitexDto){
         sitexService.createSitex(sitexDto);
    }
    @DeleteMapping("/sitex/{idSitex}")
    public void deleteSitex(@PathVariable Long idSitex) throws SitexExeption {
        sitexService.deleteSitex(idSitex);
    }




}

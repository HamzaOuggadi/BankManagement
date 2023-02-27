package ma.atos.ma.atos.bankmanagement.web;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import ma.atos.ma.atos.bankmanagement.services.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RestrictionController {
    @Autowired
    RestrictionRepository restrictionRepo;
    @Autowired
    RestrictionServiceImpl restrictionService;
    @GetMapping("/restrictions")
    public List<RestrictionDto> getRestriction(){
        return restrictionService.getResctrictions() ;
    }
    @GetMapping("/restrictions/{idRestriction}")
    public Restriction getRestrictionById(@PathVariable Long idRestriction) {
        return  restrictionService.getRestrictionById(idRestriction);
    }
    @PostMapping("/restrictions/create")
    public void createRestriction(@RequestBody RestrictionDto restrictionDto){
        restrictionService.createRestriction(restrictionDto);
    }
    @GetMapping("/restrictions/delete/{idRestriction}")
    public void deleteRestriction(@PathVariable Long idRestriction) throws RestrictionException{
        restrictionService.deleteRestriction(idRestriction);
    }
}

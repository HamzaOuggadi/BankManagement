package ma.atos.ma.atos.bankmanagement.web;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.impl.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/restriction")
@CrossOrigin("*")
public class RestrictionController {

    @Autowired
    RestrictionRepository restrictionRepo;
    @Autowired
    RestrictionServiceImpl restrictionService;
    @Autowired
    MessageSource messageSource;




    @GetMapping("/list")
    @CrossOrigin("*")
    public List<RestrictionDto> getRestriction(){
        return restrictionService.getResctrictions() ;
    }


    @GetMapping("/get/{idRestriction}")
    @CrossOrigin("*")
    public Restriction getRestrictionById(@PathVariable Long idRestriction) {
        return  restrictionService.getRestrictionById(idRestriction);
    }


    @PostMapping("/create")
    @CrossOrigin("*")
    public void createRestriction(@RequestBody RestrictionDto restrictionDto, Long idClient){
        restrictionService.createRestriction(restrictionDto, idClient);
    }


    @DeleteMapping("/deleteById/{idRestriction}")
    @CrossOrigin("*")
    public ResponseEntity<GenericResponse> deleteRestriction(@PathVariable Long idRestriction) throws RestrictionException{
        restrictionService.deleteRestriction(idRestriction);
        GenericResponse response = new GenericResponse();
        // Use message Source
        response.setDescription(messageSource.getMessage("restriction.deleted.success",new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/restrictionByTier/{idClient}")
    @CrossOrigin("*")
    public ResponseEntity<List<RestrictionDto>> getRestrictionByTier(@PathVariable Long idClient) throws RestrictionException {
        return ResponseEntity.ok(restrictionService.getRestrictionByTier(idClient));
    }
}

package ma.atos.ma.atos.bankmanagement.web;
import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import ma.atos.ma.atos.bankmanagement.services.impl.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/restriction")
public class RestrictionController {

    @Autowired
    RestrictionRepository restrictionRepo;
    @Autowired
    RestrictionServiceImpl restrictionService;
    @Autowired
    MessageSource messageSource;



    @GetMapping("/list")
    public List<RestrictionDto> getRestriction(){
        return restrictionService.getResctrictions() ;
    }


    @GetMapping("/get/{idRestriction}")
    public Restriction getRestrictionById(@PathVariable Long idRestriction) {
        return  restrictionService.getRestrictionById(idRestriction);
    }


    @PostMapping("/create")
    public void createRestriction(@RequestBody RestrictionDto restrictionDto){
        restrictionService.createRestriction(restrictionDto);
    }


    @GetMapping("/deleteById/{idRestriction}")
    public ResponseEntity<GenericResponse> deleteRestriction(@PathVariable Long idRestriction) throws RestrictionException{
        restrictionService.deleteRestriction(idRestriction);
        GenericResponse response = new GenericResponse();
        // Use message Source
        response.setDescription("Restriction deleted Successfully");
        return ResponseEntity.ok(response);
    }
}

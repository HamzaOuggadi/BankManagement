package ma.atos.ma.atos.bankmanagement.web;

import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.mappers.RestrictionMapper;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import ma.atos.ma.atos.bankmanagement.services.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class RestrictionController {
    @Autowired
    RestrictionRepository restrictionRepo;
    RestrictionMapper restrictionMapper ;
    MessageSource messageSource;
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

    @GetMapping("/restrictions/creatRestriction")
    public void createRestriction(@RequestBody RestrictionDto restrictionDto){
        restrictionService.createRestriction(restrictionDto);

    }
    @GetMapping("/restriction/deleteRestriction")
    public void deleteRestriction(@PathVariable Long idRestriction) throws RestrictionException{
        restrictionService.deleteRestriction(idRestriction);

    }
}

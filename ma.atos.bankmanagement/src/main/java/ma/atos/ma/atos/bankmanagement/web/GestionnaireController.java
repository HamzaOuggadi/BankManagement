package ma.atos.ma.atos.bankmanagement.web;

import ma.atos.ma.atos.bankmanagement.dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import ma.atos.ma.atos.bankmanagement.repositories.GestionnaireRepository;
import ma.atos.ma.atos.bankmanagement.services.impl.GestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/gestionnaire")
@CrossOrigin(origins = "http://localhost:4200/")
public class GestionnaireController {

    @Autowired GestionnaireRepository gestionnaireRepository;
    @Autowired GestionnaireServiceImpl gestionnaireService;
    @Autowired MessageSource messageSource;

    @GetMapping("/get/{idGestionnaire}")
    @CrossOrigin("*")
    public Gestionnaire getGestionnaireByNumGes(@PathVariable Long idGestionnaire){
        return gestionnaireService.getGestionnaire(idGestionnaire);
    }

    @PostMapping("/create")
    @CrossOrigin("*")
    public void createGestionnaire(@RequestBody GestionnaireDto gestionnaireDto){
        gestionnaireService.createGestionnaire(gestionnaireDto);
    }

    @DeleteMapping("/deletebyId/{idGestionnaire}")
    @CrossOrigin("*")
    public ResponseEntity<GenericResponse> deleteGestionnaire(@PathVariable Long idGestionnaire){
        gestionnaireService.deleteGestionnaire(idGestionnaire);
        GenericResponse response = new GenericResponse();
        response.setDescription(messageSource.getMessage("gestionnaire.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }


}

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

@RestController("/gestionnaire")
public class GestionnaireController {

    @Autowired GestionnaireRepository gestionnaireRepository;
    @Autowired GestionnaireServiceImpl gestionnaireService;
    @Autowired MessageSource messageSource;

    @GetMapping("/get/{idGestionnaire}")
    public Gestionnaire getGestionnaireByNumGes(@PathVariable Long idGestionnaire){
        return gestionnaireService.getGestionnaire(idGestionnaire);
    }

    @PostMapping("/create")
    public void createGestionnaire(@RequestBody GestionnaireDto gestionnaireDto){
        gestionnaireService.createGestionnaire(gestionnaireDto);
    }

    @GetMapping("/deletebyId/{idGestionnaire}")
    public ResponseEntity<GenericResponse> deleteGestionnaire(@PathVariable Long idGestionnaire){
        gestionnaireService.deleteGestionnaire(idGestionnaire);
        GenericResponse response = new GenericResponse();
        response.setDescription("Getionnaire Deleted Successfully");
        return ResponseEntity.ok(response);
    }


}

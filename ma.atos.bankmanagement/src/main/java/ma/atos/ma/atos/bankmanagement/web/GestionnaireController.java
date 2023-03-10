package ma.atos.ma.atos.bankmanagement.web;

import ma.atos.ma.atos.bankmanagement.Dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import ma.atos.ma.atos.bankmanagement.exceptions.GestionnaireException;
import ma.atos.ma.atos.bankmanagement.repositories.GestionnaireRepository;
import ma.atos.ma.atos.bankmanagement.services.GestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GestionnaireController {
    @Autowired GestionnaireRepository gestionnaireRepository;
    @Autowired GestionnaireServiceImpl gestionnaireService;
    @Autowired MessageSource messageSource;

    @GetMapping("/gestionnaire/{idGestionnaire}")
    public Gestionnaire getGestionnaireByNumGes(@PathVariable Long idGestionnaire){
        return gestionnaireService.getGestionnaire(idGestionnaire);
    }

    @PostMapping("/gestionnaire/create")
    public void createGestionnaire(@RequestBody GestionnaireDto gestionnaireDto){
        gestionnaireService.createGestionnaire(gestionnaireDto);
    }

    @GetMapping("/gestionnaire/delete/{idGestionnaire}")
    public ResponseEntity<GenericResponse> deleteGestionnaire(@PathVariable Long idGestionnaire){
        gestionnaireService.deleteGestionnaire(idGestionnaire);
        GenericResponse response = new GenericResponse();
        response.setDescription("Getionnaire Deleted Successfully");
        return ResponseEntity.ok(response);
    }


}

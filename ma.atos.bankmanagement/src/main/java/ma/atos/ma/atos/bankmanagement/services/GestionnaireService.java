package ma.atos.ma.atos.bankmanagement.services;
import ma.atos.ma.atos.bankmanagement.dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;

import java.util.List;


public interface GestionnaireService {

    List<GestionnaireDto> getGestionnaire();
    Gestionnaire getGestionnaire(Long idGestionnaire);
    void createGestionnaire(GestionnaireDto gestionnaireDto);
    void deleteGestionnaire(Long idGestionnaire);
}

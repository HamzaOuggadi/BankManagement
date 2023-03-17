package ma.atos.ma.atos.bankmanagement.services;
import ma.atos.ma.atos.bankmanagement.dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;


public interface GestionnaireService {

    Gestionnaire getGestionnaire(Long idGestionnaire);
    void createGestionnaire(GestionnaireDto gestionnaireDto);
    void deleteGestionnaire(Long idGestionnaire);
}

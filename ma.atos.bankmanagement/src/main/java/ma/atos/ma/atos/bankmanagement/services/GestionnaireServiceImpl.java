package ma.atos.ma.atos.bankmanagement.services;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.GestionnaireException;
import ma.atos.ma.atos.bankmanagement.mappers.CompteMapper;
import ma.atos.ma.atos.bankmanagement.mappers.GestionnaireMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.GestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
@AllArgsConstructor
public class GestionnaireServiceImpl implements GestionnaireService {
    @Autowired GestionnaireMapper gestionnaireMapper;
    @Autowired GestionnaireRepository gestionnaireRepository;
    @Autowired MessageSource messageSource;

    @Override
    public Gestionnaire getGestionnaire(Long idGestionnaire){
        return gestionnaireRepository.findById(idGestionnaire).orElse(null);
    };

    @Override
    public void createGestionnaire(GestionnaireDto gestionnaireDto){
        Gestionnaire gestionnaire = gestionnaireMapper.gestionnaireDtoToGestionnaire(gestionnaireDto);
        gestionnaireRepository.save(gestionnaire);
    }

    @Override
    public void deleteGestionnaire(Long idGestionnaire) throws GestionnaireException {
        gestionnaireRepository.findById(idGestionnaire).orElseThrow(()-> new GestionnaireException(
                messageSource.getMessage("gestionnaire.not.found.exception", new Object[]{}
                        , Locale.getDefault()), HttpStatus.OK));
        try {
            gestionnaireRepository.deleteById(idGestionnaire);
        } catch (Exception e){
            throw new GestionnaireException("Gestionnaire Deleted Successfully");
        };

    };
}

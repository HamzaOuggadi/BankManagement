package ma.atos.ma.atos.bankmanagement.services.impl;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.GestionnaireException;
import ma.atos.ma.atos.bankmanagement.mappers.GestionnaireMapper;
import ma.atos.ma.atos.bankmanagement.repositories.GestionnaireRepository;
import ma.atos.ma.atos.bankmanagement.services.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class GestionnaireServiceImpl implements GestionnaireService {
    @Autowired GestionnaireMapper gestionnaireMapper;
    @Autowired GestionnaireRepository gestionnaireRepository;
    @Autowired MessageSource messageSource;

    @Override
    public List<GestionnaireDto> getGestionnaire() {
        List<Gestionnaire> gestionnaireDtoList = gestionnaireRepository.findAll();
        List<GestionnaireDto> gestionnaireDtos = new ArrayList<>();
        gestionnaireDtoList.stream().forEach(gestionnaire -> {
            gestionnaireDtos.add(gestionnaireMapper.gestionnaireToGestionnaireDto(gestionnaire));
        });
        return gestionnaireDtos;
    }

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

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;

import java.util.List;

public interface RestrictionService {
    List<RestrictionDto> getResctrictions();
    Restriction getRestrictionById(Long idRestriction);
    void createRestriction( RestrictionDto restrictionDto);
    void deleteRestriction(Long idRestriction) throws RestrictionException ;
}

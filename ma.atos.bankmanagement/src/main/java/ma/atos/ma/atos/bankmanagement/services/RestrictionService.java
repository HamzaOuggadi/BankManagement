package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.entities.Restriction;

import java.util.List;

public interface RestrictionService {
    List<Restriction> getResctriction();
    Restriction getRestricionById(Long idRestriction);
    Restriction createRestriction( Restriction restriction);
    void deleteRestriction(Long idRestriction);
}

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;

import java.util.List;

public interface TierService {
    List<PersonnePhysiqueDto> getAllPersonne();
    List<PersonneMoraleDto> getAllPersonneMorale();
    PersonnePhysiqueDto getPersonnePhysique(long id);
    PersonneMoraleDto getPersonneMorale(long id);
    PersonneMorale creatPersonneMorale(PersonneMoraleDto personneMoraleDto);
    PersonnePhysiqueDto creatPersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto );
    void DeletPersonnePhysique(long numClient);
    void DeletPersonneMorale(long typeIdentification);

}

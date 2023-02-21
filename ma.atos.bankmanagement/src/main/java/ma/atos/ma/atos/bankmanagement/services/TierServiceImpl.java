package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.mappers.PersonneMoraleMapper;
import ma.atos.ma.atos.bankmanagement.mappers.PersonnePhysiqueMapper;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class TierServiceImpl implements TierService {
    @Autowired
    PersonnePhysiqueMapper personnePhysiqueMapper;

@Autowired
    PersonneMoraleMapper personneMoraleMapper;
    @Autowired
    TierRepository tierRepository;


    @Override
    public List<PersonnePhysiqueDto> getAllPersonne() {
        return null;
  }
 @Override
    public List<PersonneMoraleDto> getAllPersonneMorale() {
        return null;
 }
 @Override
    public PersonnePhysiqueDto getPersonnePhysique(long id) {
        return null;
    }

    @Override
    public PersonneMoraleDto getPersonneMorale(long id) {
        return null;
    }

    @Override
    public PersonneMorale creatPersonneMorale(PersonneMoraleDto personneMoraleDto) {
        PersonneMorale personneMorale = personneMoraleMapper.PmDtoToPm(personneMoraleDto);
        return tierRepository.save(personneMorale);
    }



        @Override
    public PersonnePhysiqueDto creatPersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto) {
        return tierRepository.save(personnePhysiqueDto);

    }

    @Override
    public void DeletPersonnePhysique(long numClient) {

    }

   @Override
    public void DeletPersonneMorale(long typeIdentification) {

    }
}
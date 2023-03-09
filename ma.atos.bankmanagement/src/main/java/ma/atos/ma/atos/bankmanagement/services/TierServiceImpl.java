package ma.atos.ma.atos.bankmanagement.services;
import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;

import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;
import ma.atos.ma.atos.bankmanagement.mappers.PersonneMoraleMapper;
import ma.atos.ma.atos.bankmanagement.mappers.PersonnePhysiqueMapper;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class TierServiceImpl implements TierService {
    @Autowired
    MessageSource messageSource;
@Autowired
      PersonneMoraleMapper personneMoraleMapper;
@Autowired
    PersonnePhysiqueMapper personnePhysiqueMapper;
@Autowired
   TierRepository tierRepository;
  /*  @Override
    public List<PersonneMoraleDto> getAllPersonneMorale() {
        List<Tier> personneMorales= tierRepository.findByTierType("PM");
        List<PersonneMoraleDto> personneMoraleDtos = personneMorales.stream().map(personneMorale ->
                personneMoraleMapper.personneToPersonneDto((PersonneMorale) personneMorale)).collect(Collectors.toList());
        return personneMoraleDtos;
    }*/
    @Override
    public List<PersonneMoraleDto> getAllPersonneMorale() {
        List<PersonneMorale> personneMorales= tierRepository.findPMByTierType("PM");
        List<PersonneMoraleDto> personneMoraleDtos = new ArrayList<>();
        personneMorales.stream().forEach(personneMorale ->{
        personneMoraleDtos.add(personneMoraleMapper.personneToPersonneDto(personneMorale));
        });
        return personneMoraleDtos;}
    @Override
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption {
        PersonneMorale pp = (PersonneMorale) tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id);
        log.info("ID du tiers est " + id);
        PersonneMorale personneMorale = (PersonneMorale) tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id);
        if(personneMorale==null){
            throw   new TierNotFoundExeption("Personne Morale not found ","Tier.not.found.exception");}
        return personneMoraleMapper.personneToPersonneDto(personneMorale);
    }
   /* @Override
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption {
        PersonneMorale pp = (PersonneMorale) tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id);
        log.info("ID du tiers est " + id);
        PersonneMorale personneMorale = (PersonneMorale) tierRepository.findById(id).orElseThrow(() ->
                new TierNotFoundExeption(messageSource.getMessage("Tier.not.found.exception",new Object[]{}, Locale.getDefault())));
        return personneMoraleMapper.personneToPersonneDto(personneMorale);
    }*/
    @Override
    public PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto) {
        PersonneMorale personneMorale =personneMoraleMapper.PmDtoToPm(personneMoraleDto);
        PersonneMorale savePersonneMorale=  tierRepository.save(personneMorale);
        return personneMoraleMapper.personneToPersonneDto(savePersonneMorale);
    }
    @Override
    public int deletPersonneMorale(long id)throws TierNotFoundExeption
    {
        if(tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id)==null){

            throw new TierNotFoundExeption("Personne Morale not found ","Tier.not.found.exception");
        }
        else{
            tierRepository.deleteById(id);
        }
        return 1;
    }

    @Override
    public List<PersonnePhysiqueDto> getAllPersonnePhysique() {
        List<PersonnePhysique> personnePhysiques= tierRepository.findPPByTierType("PP");
        List<PersonnePhysiqueDto> personnePhysiqueDtos = new ArrayList<>();
        personnePhysiques.stream().forEach(personnePhysique ->{
            personnePhysiqueDtos.add(personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(personnePhysique));
        });
        return personnePhysiqueDtos;
    }
    @Override
    public PersonnePhysiqueDto getPersonnePhysique(Long id) throws TierNotFoundExeption {
        PersonnePhysique pp = (PersonnePhysique) tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id);
        log.info("ID du tiers est " + id);
        PersonnePhysique personnePhysique = (PersonnePhysique) tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id);
              if(personnePhysique==null){
             throw    new TierNotFoundExeption("Personne Physique not found ","Tier.not.found.exception");}
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(personnePhysique);
    }
    @Override
    public PersonnePhysiqueDto savePersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto) {
        PersonnePhysique personnePhysique =personnePhysiqueMapper.PpDtoToPp(personnePhysiqueDto);
        PersonnePhysique savePersonnePhysique=tierRepository.save(personnePhysique);
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(savePersonnePhysique);
    }
    @Override
    public int deletPersonnePhysique(long id) throws TierNotFoundExeption {
        if(tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id)==null){
            throw new TierNotFoundExeption("Personne Physique not found ","Tier.not.found.exception");
        }
        else{
            tierRepository.deleteById(id);
        }
        return 1;
    }

 }
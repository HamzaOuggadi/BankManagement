package ma.atos.ma.atos.bankmanagement.services;
import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;

import ma.atos.ma.atos.bankmanagement.entities.Tier;
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
        log.info(pp.toString());
        PersonneMorale personneMorale = (PersonneMorale) tierRepository.findById(id).orElseThrow(() ->
                new TierNotFoundExeption(messageSource.getMessage("Tier.not.found.exception",new Object[]{}, Locale.getDefault())));
        return personneMoraleMapper.personneToPersonneDto(personneMorale);
    }
    @Override
    public PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto) {
        PersonneMorale personneMorale =personneMoraleMapper.PmDtoToPm(personneMoraleDto);
        PersonneMorale savePersonneMorale=  tierRepository.save(personneMorale);
        return personneMoraleMapper.personneToPersonneDto(savePersonneMorale);
    }
    @Override
    public void deletPersonneMorale(long id) {

        tierRepository.deleteById(id);
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
        log.info(pp.toString());
        PersonnePhysique personnePhysique = (PersonnePhysique) tierRepository.findById(id).orElseThrow(() ->
                new TierNotFoundExeption(messageSource.getMessage("Tier Not Found Exeption",new Object[]{}, Locale.getDefault())));
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(personnePhysique);

    }

    @Override
    public PersonnePhysiqueDto savePersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto) {
        PersonnePhysique personnePhysique =personnePhysiqueMapper.PpDtoToPp(personnePhysiqueDto);
        PersonnePhysique savePersonnePhysique=  tierRepository.save(personnePhysique);
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(savePersonnePhysique);
    }

    @Override
    public void deletPersonnePhysique(long id) {
        tierRepository.deleteById(id);
    }
  /*  @Override
    public TierDto getTier(long Id) throws TierNotFoundExeption {

        Tier tier = tierRepository.findById(Id)
                .orElseThrow(() -> new TierNotFoundExeption("Tier not found"));

        if (tier instanceof PersonnePhysique) {
            PersonnePhysique personnePhysique = (PersonnePhysique) tier;
            return tierRepository.personnePhysiqueToPersonnePhysiqueDto(personnePhysique);
        } else {
            PersonneMorale personneMorale = (PersonneMorale) tier;
            return tierRepository.personneToPersonneDto(personneMorale);
        }
    }*/ }
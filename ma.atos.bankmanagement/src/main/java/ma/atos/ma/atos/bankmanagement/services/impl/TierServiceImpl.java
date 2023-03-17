package ma.atos.ma.atos.bankmanagement.services.impl;
import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;

import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;
import ma.atos.ma.atos.bankmanagement.mappers.PersonneMoraleMapper;
import ma.atos.ma.atos.bankmanagement.mappers.PersonnePhysiqueMapper;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TierServiceImpl implements TierService {

    @Autowired
    PersonneMoraleMapper personneMoraleMapper;

    @Autowired
    PersonnePhysiqueMapper personnePhysiqueMapper;

    @Autowired
    TierRepository tierRepository;


    /**
     * This service allows to get all the customers.
     * @return
     */
    @Override
    public List<PersonneMoraleDto> getAllPersonneMorale() {
        List<PersonneMorale> personneMorales= tierRepository.findPMByTierType("PM");
        List<PersonneMoraleDto> personneMoraleDtos = new ArrayList<>();
        personneMorales.stream().forEach(personneMorale ->{
        personneMoraleDtos.add(personneMoraleMapper.personneToPersonneDto(personneMorale));
        });
        return personneMoraleDtos;}

    /**
     * This service allows to get one customer
     * @param id
     * @return
     * @throws TierNotFoundExeption
     */
    @Override
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption {
        PersonneMorale pp = (PersonneMorale) tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id);
        log.info("ID du tiers est " + id);
        PersonneMorale personneMorale = (PersonneMorale) tierRepository.findByTierTypeEqualsAndIdClientEquals("PM", id);
        if(personneMorale==null){
            throw   new TierNotFoundExeption("Personne Morale not found ","Tier.not.found.exception");}
        return personneMoraleMapper.personneToPersonneDto(personneMorale);
    }


    /**
     * Create a customer
     * @param personneMoraleDto
     * @return
     */

    @Override
    public PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto) {
        PersonneMorale personneMorale =personneMoraleMapper.PmDtoToPm(personneMoraleDto);
        PersonneMorale savePersonneMorale=  tierRepository.save(personneMorale);
        return personneMoraleMapper.personneToPersonneDto(savePersonneMorale);
    }


    /**
     * delete a customer
     * @param id
     * @return
     * @throws TierNotFoundExeption
     */

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


    /**
     *
     * @return
     */

    @Override
    public List<PersonnePhysiqueDto> getAllPersonnePhysique() {
        List<PersonnePhysique> personnePhysiques= tierRepository.findPPByTierType("PP");
        List<PersonnePhysiqueDto> personnePhysiqueDtos = new ArrayList<>();
        personnePhysiques.stream().forEach(personnePhysique ->{
            personnePhysiqueDtos.add(personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(personnePhysique));
        });
        return personnePhysiqueDtos;
    }


    /**
     *
     * @param id
     * @return
     * @throws TierNotFoundExeption
     */
    @Override
    public PersonnePhysiqueDto getPersonnePhysique(Long id) throws TierNotFoundExeption {
        PersonnePhysique pp = (PersonnePhysique) tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id);
        log.info("ID du tiers est " + id);
        PersonnePhysique personnePhysique = (PersonnePhysique) tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id);
              if(personnePhysique==null){
             throw    new TierNotFoundExeption("Personne Physique not found ","Tier.not.found.exception");}
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(personnePhysique);
    }


    /**
     *
     * @param personnePhysiqueDto
     * @return
     */
    @Override
    public PersonnePhysiqueDto savePersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto) {
        PersonnePhysique personnePhysique =personnePhysiqueMapper.PpDtoToPp(personnePhysiqueDto);
        PersonnePhysique savePersonnePhysique=tierRepository.save(personnePhysique);
        return personnePhysiqueMapper.personnePhysiqueToPersonnePhysiqueDto(savePersonnePhysique);
    }


    /**
     *
     * @param id
     * @return
     * @throws TierNotFoundExeption
     */

    @Override
    public int deletPersonnePhysique(long id) throws TierNotFoundExeption {
        if(tierRepository.findByTierTypeEqualsAndIdClientEquals("PP", id)==null){
            // Use the message source
            throw new TierNotFoundExeption("Personne Physique not found ","Tier.not.found.exception");
        }
        else{
            tierRepository.deleteById(id);
        }
        return 1;
    }

 }
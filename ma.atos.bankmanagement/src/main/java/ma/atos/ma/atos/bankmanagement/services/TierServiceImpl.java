package ma.atos.ma.atos.bankmanagement.services;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.config.MessageConfiguration;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
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
        List<PersonneMorale> personneMorales= tierRepository.findByTierType("PM");
        List<PersonneMoraleDto> personneMoraleDtos = new ArrayList<>();
        personneMorales.stream().forEach(personneMorale ->{
        personneMoraleDtos.add(personneMoraleMapper.personneToPersonneDto(personneMorale));
        });
        return personneMoraleDtos;}
    @Override
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption {
        PersonneMorale personneMorale = (PersonneMorale) tierRepository.findById(id).orElseThrow(() ->
                new TierNotFoundExeption(messageSource.getMessage("Tier Not Found Exeption",new Object[]{}, Locale.getDefault())));
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
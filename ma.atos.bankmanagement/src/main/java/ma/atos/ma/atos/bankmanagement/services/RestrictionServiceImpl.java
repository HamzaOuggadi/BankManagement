package ma.atos.ma.atos.bankmanagement.services;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.config.MessageConfiguration;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.mappers.RestrictionMapper;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import org.aspectj.weaver.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
@AllArgsConstructor
public class RestrictionServiceImpl implements RestrictionService {
    RestrictionRepository restrictionRepo;
    RestrictionMapper restrictionMapper;
    MessageSource messageSource;


    @Override
    public List<RestrictionDto> getResctriction() {
        List<Restriction> restrictionDtoList = restrictionRepo.findAll();
        List<RestrictionDto> result = new ArrayList<>();
        restrictionDtoList.stream().forEach(restriction -> {
            result.add(restrictionMapper.restrictionToRestrictionDto(restriction));
        });
        return result;
    }
    @Override
    public Restriction getRestricionById(Long idRestriction){
        return  restrictionRepo.findById(idRestriction).orElse(null);
    }
    @Override
    public void createRestriction( RestrictionDto restrictionDto) {
        Restriction restriction = restrictionMapper.restrictionDtoToRestriction(restrictionDto);
        restrictionRepo.save(restriction) ;
    }
    @Override
    public void deleteRestriction(Long idRestriction) throws RestrictionException {
        if (restrictionRepo.findById(idRestriction)== null){
            throw new RestrictionException(
                    messageSource.getMessage("idrestriction.empty", new Object[]{}, Locale.getDefault())
                            , HttpStatus.BAD_REQUEST);
        }
        else{
            restrictionRepo.deleteById(idRestriction);
        }
    }
}






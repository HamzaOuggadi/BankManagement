package ma.atos.ma.atos.bankmanagement.services.impl;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.entities.Tier;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.mappers.RestrictionMapper;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.RestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class
RestrictionServiceImpl implements RestrictionService {
    @Autowired
    RestrictionRepository restrictionRepo;
    @Autowired
    RestrictionMapper restrictionMapper;
    @Autowired
    MessageSource messageSource;
    @Autowired
    TierRepository tierRepository;


    @Override
    public List<RestrictionDto> getResctrictions() {
        List<Restriction> restrictionDtoList = restrictionRepo.findAll();
        List<RestrictionDto> restrictionDtos = new ArrayList<>();
        restrictionDtoList.stream().forEach(restriction -> {
            restrictionDtos.add(restrictionMapper.restrictionToRestrictionDto(restriction));
        });
        return restrictionDtos;
    }


    @Override
    public List<RestrictionDto> getRestrictionByTier(Long idClient) throws RestrictionException{
        List<Restriction> restrictions = restrictionRepo.findRestrictionsByTier_IdClient(idClient);
        if (!CollectionUtils.isEmpty(restrictions)) {
            List<RestrictionDto> restrictionDtos = new ArrayList<>();
            restrictions.stream().forEach(restriction -> {
                RestrictionDto restrictionDto = restrictionMapper.restrictionToRestrictionDto(restriction);
                restrictionDto.setEtat(String.valueOf(restrictionDto.getEtat()));
                restrictionDtos.add(restrictionDto);
            });
            return restrictionDtos;
        } else {
            throw new RestrictionException( messageSource.getMessage("Restriction.not.found.message", new Object[]{}, Locale.getDefault()),
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restriction getRestrictionById(Long idRestriction){
        return  restrictionRepo.findById(idRestriction).orElse(null);
    }
    @Override
    public void createRestriction( RestrictionDto restrictionDto, Long idClient) {
        Restriction restriction = restrictionMapper.restrictionDtoToRestriction(restrictionDto);
        Tier tier = tierRepository.findByIdClient(idClient);
        restriction.setTier(tier);
        restrictionRepo.save(restriction) ;
    }
    @Override
    public void deleteRestriction(Long idRestriction) throws RestrictionException {
        restrictionRepo.findById(idRestriction).orElseThrow(()-> new RestrictionException(
                messageSource.getMessage("Restriction.not.found.message", new Object[]{}
                        , Locale.getDefault()), HttpStatus.OK) );
        try {
            restrictionRepo.deleteById(idRestriction);
        } catch (Exception e) {
            throw new  RestrictionException("Failed to delete restriction !");
        }
    }
}





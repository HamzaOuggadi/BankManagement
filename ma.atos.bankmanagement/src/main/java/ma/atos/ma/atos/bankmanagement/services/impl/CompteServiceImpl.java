package ma.atos.ma.atos.bankmanagement.services.impl;


import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Tier;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;
import ma.atos.ma.atos.bankmanagement.mappers.CompteMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Transactional
@Slf4j
public class CompteServiceImpl implements CompteService {
    @Autowired CompteRepository compteRepository;
    @Autowired TierRepository tierRepository;

    @Autowired CompteMapper compteMapper;

    @Autowired RestTemplate restTemplate;

    @Autowired MessageSource messageSource;

    @Override
    public List<CompteDto> listComptes() throws CompteException {
        List<Compte> comptes = compteRepository.findAll();
        List<CompteDto> compteDtos = new ArrayList<>();
        if(!CollectionUtils.isEmpty(comptes)) {
            comptes.stream().forEach(compte -> {
                compteDtos.add(compteMapper.compteToCompteDto(compte));
            });
        } else {
            throw new CompteException(
                    messageSource.getMessage("account.list.not.found.message", new Object[]{}, Locale.getDefault()),
                    messageSource.getMessage("account.list.not.found.messageFront", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_COMPTE_300,
                    HttpStatus.NOT_FOUND);
        }

        return compteDtos;
    }

    @Override
    public CompteDto getCompte(Long ribCompte) throws CompteException {

        // CALL THE SITEX API REST START /////
        // Method HTTP , RequestBody Path Variable
        /*SitexDto sitexDto = new SitexDto();
        sitexDto.setType("Frozen");
        String url = hostSitex.concat(actionCreateSitex);

        ResponseEntity<String> result = restTemplate
                .postForEntity(
                        url,
                        sitexDto,
                        String.class);

        log.info("Sitex crée avec succes pour ce compte, réponse d'API est  " + result.getBody());*/

        // CALL THE SITEX API REST END   ////

        Compte compte = compteRepository.findByRibCompte(ribCompte);

        if (compte == null) {
            throw new CompteException(
                    messageSource.getMessage("account.not.found.message", new Object[]{ribCompte}, Locale.getDefault()),
                    messageSource.getMessage("account.not.found.messageFront", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_COMPTE_100,
                    HttpStatus.NOT_FOUND);
        } else {
            return compteMapper.compteToCompteDto(compte);
        }
    }

    /**
     *
     * @param numClient
     * @return
     * @throws CompteException
     */
    @Override
    public List<CompteDto> getCompteByTier(String numClient) throws CompteException, TierNotFoundExeption {
        Tier tier = tierRepository.findByNumClient(numClient);
        System.out.println("------------------>" + tier.toString());
        if (tier == null) {
            throw new TierNotFoundExeption("Can't Find Customer");
        } else {
            List<Compte> comptes = tier.getComptes();
            System.out.println("------------------>" + comptes.toString());
            List<CompteDto> compteDtos = new ArrayList<>();
            if (!CollectionUtils.isEmpty(comptes)) {
                comptes.stream().forEach(compte -> {
                    compteDtos.add(compteMapper.compteToCompteDto(compte));
                });
            } else {
                throw new CompteException(
                        messageSource.getMessage("account.list.not.found.message", new Object[]{}, Locale.getDefault()),
                        messageSource.getMessage("account.list.not.found.messageFront", new Object[]{}, Locale.getDefault()),
                        ApiStatusCode.API_COMPTE_300,
                        HttpStatus.NOT_FOUND);
            }
            return compteDtos;
        }
    }

    /**
     *
     * @param compteDto
     * @throws CompteException
     */
    @Override
    public void createCompte(CompteDto compteDto, String numClient, Long idGestionnaire) throws CompteException {
        Random random = new Random();
        try {
            compteDto.setRibCompte(random.nextLong() & Long.MAX_VALUE);
            Compte compte = compteMapper.compteDtoToCompte(compteDto);
            Tier tier = tierRepository.findByNumClient(numClient);
            compte.setTier(tier);
            compte.setDateCreation(new Date());
            compteRepository.save(compte);
        } catch (Exception e) {
            throw new CompteException(
                    messageSource.getMessage("account.creation.failed.message", new Object[]{}, Locale.getDefault()),
                    messageSource.getMessage("account.creation.failed.messageFront", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_COMPTE_200,
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @Override
    public void deleteCompte(Long ribCompte) throws CompteException {
        if (compteRepository.findCompteByRibCompte(ribCompte) == null) {
            throw new CompteException(
                    messageSource.getMessage("account.not.found.message", new Object[]{ribCompte}, Locale.getDefault()),
                    messageSource.getMessage("account.not.found.messageFront", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_COMPTE_100,
                    HttpStatus.NOT_FOUND);
        } else {
            compteRepository.delete(compteRepository.findCompteByRibCompte(ribCompte));
        }
    }


}

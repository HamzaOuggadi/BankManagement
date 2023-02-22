package ma.atos.ma.atos.bankmanagement.services;


import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Tier;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.mappers.CompteMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CompteServiceImpl implements CompteService {
    @Autowired CompteRepository compteRepository;
    @Autowired TierRepository tierRepository;

    @Autowired CompteMapper compteMapper;


    @Override
    public List<CompteDto> listComptes() throws CompteException {
        List<Compte> comptes = compteRepository.findAll();
        List<CompteDto> compteDtos = new ArrayList<>();;
        if(!CollectionUtils.isEmpty(comptes)) {
            comptes.stream().forEach(compte -> {
                compteDtos.add(compteMapper.compteToCompteDto(compte));
            });
        } else {
            throw new CompteException("Account Not Found !");
        }

        return compteDtos;
    }

    @Override
    public CompteDto getCompte(Long ribCompte) {
        Compte compte = compteRepository.findCompteByRibCompte(ribCompte);
        CompteDto compteDto = compteMapper.compteToCompteDto(compte);
        return compteDto;
    }
    @Override
    public List<CompteDto> getCompteByTier(String numClient) throws CompteException {
        Tier tier = tierRepository.findByNumClient(numClient);
        List<Compte> comptes = tier.getComptes();
        List<CompteDto> compteDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(comptes)) {
            comptes.stream().forEach(compte -> {
                compteDtos.add(compteMapper.compteToCompteDto(compte));
            });
        } else {
            throw new CompteException("Account Not Found!");
        }
        return compteDtos;
    }

    @Override
    public void createCompte(CompteDto compteDto) {
        Compte compte = compteMapper.compteDtoToCompte(compteDto);
        compteRepository.save(compte);
    }

    @Override
    public void deleteCompte(Long ribCompte) throws CompteException {
        if (compteRepository.findCompteByRibCompte(ribCompte) == null) {
            throw new CompteException("Account Not Found!");
        } else {
            compteRepository.delete(compteRepository.findCompteByRibCompte(ribCompte));
        }
    }
}

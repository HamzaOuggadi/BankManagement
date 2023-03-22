package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;

import java.util.List;
import java.util.Locale;

public interface CompteService {
    List<CompteDto> listComptes() throws CompteException;
    CompteDto getCompte(Long ribCompte) throws CompteException;
    List<CompteDto> getCompteByTier(String numClient) throws CompteException, TierNotFoundExeption;
    List<CompteDto> getCompteByGestionnaire(Long idGestionnaire);
    void createCompte(CompteDto compteDto, String numClient, Long idGestionnaire) throws CompteException;
    void deleteCompte(Long ribCompte) throws CompteException;
}

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.entities.Sitex;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;

import java.util.List;

public interface SitexService {
    List<SitexDto> listSitex() throws SitexExeption;
    SitexDto getSitex(Long idSitex);
    Sitex createSitex(SitexDto sitexDto);
    void deleteSitex(Long idSitex) throws SitexExeption ;
}

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.entities.Sitex;

import java.util.List;

public interface SitexService {

    List<Sitex> getSitex();
    Sitex getSitexById(Long idSitex);
    Sitex createSitex(Sitex sitex);
    void deleteSitex(Long idSitex);
}

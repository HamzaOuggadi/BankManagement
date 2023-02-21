package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.entities.Sitex;
import ma.atos.ma.atos.bankmanagement.repositories.SitexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SitexServiceImpl implements SitexService{

    @Autowired
    SitexRepository sitexRepository;

    @Override
    public List<Sitex> getSitex() {
      return null;
    }

    @Override
    public Sitex getSitexById(Long idSitex) {
        return null;
    }

    @Override
    public Sitex createSitex(Sitex sitex) {
      return sitexRepository.save(sitex);
    }

    @Override
    public void deleteSitex(Long idSitex) {
        sitexRepository.deleteById(idSitex);
    }
}

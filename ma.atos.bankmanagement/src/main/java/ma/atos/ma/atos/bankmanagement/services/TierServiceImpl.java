package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.entities.Tier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class TierServiceImpl implements TierService {


    @Override
    public List<PersonnePhysique> getAllPersonne() {

        return null;
    }

    @Override
    public List<PersonneMorale> getAllPersonneMorale() {
        return null;
    }

    @Override
    public PersonnePhysique getPersonnePhysique(long id) {
        return null;
    }

    @Override
    public PersonneMorale getPersonneMorale(long id) {
        return null;
    }

    @Override
    public PersonneMorale creatPersonneMorale(String raionSociale, String numRegisterComm, String numClient, String nationalite, Date dateSouscription, String adress) {
        PersonneMorale personneMorale=PersonneMoraleRepository.save(personneMorale);


        return personneMorale;
    }

    @Override
    public void creatPersonnePhysique(Long idClient, String numClient, String nationalite, Date dateSouscription, String adresse, String nomCompet, Date dateNaissance, String typeIdentification, String numTel, String email) {

    }

    @Override
    public void DeletPersonnePhysique(long numClient) {

    }

    @Override
    public void DeletPersonneMorale(long typeIdentification) {

    }
}

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.entities.Tier;

import java.util.Date;
import java.util.List;

public interface TierService {
    List<PersonnePhysique> getAllPersonne();
    List<PersonneMorale> getAllPersonneMorale();
    PersonnePhysique getPersonnePhysique(long id);
    PersonneMorale getPersonneMorale(long id);
    void creatPersonneMorale( String raionSociale,String numRegisterComm,String numClient,String nationalite,Date dateSouscription,String adress);
    void creatPersonnePhysique(  Long idClient, String numClient, String nationalite, Date dateSouscription, String adresse,String nomCompet,Date dateNaissance,String typeIdentification,String numTel,String email);
    void DeletPersonnePhysique(long numClient);
    void DeletPersonneMorale(long typeIdentification);

}

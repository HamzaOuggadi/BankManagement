package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findCompteByRibCompte(Long ribCompte);


    Compte findByRibCompte(Long ribCompte);

}

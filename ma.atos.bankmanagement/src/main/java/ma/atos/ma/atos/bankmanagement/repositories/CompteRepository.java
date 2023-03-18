package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface CompteRepository extends JpaRepository<Compte, Long> {

    @Override
    Optional<Compte> findById(Long aLong);

    Compte findByRibCompte(Long ribCompte);

    List<Compte> searchByTierNumClient(String numClient);

}

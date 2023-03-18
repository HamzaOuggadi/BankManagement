package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.entities.Tier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TierRepository extends JpaRepository<Tier, Long> {
    Tier findByNumClient(String numClient);

    List<PersonnePhysique> findPPByTierType(String type);
    List<PersonneMorale> findPMByTierType(String type);

    Tier findByTierTypeEqualsAndIdClientEquals(String type, Long idClient);
}


package ma.atos.ma.atos.bankmanagement.repositories;


import ma.atos.ma.atos.bankmanagement.entities.Sitex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Tiers Service database Layer for Entity {@link ma.atos.ma.atos.bankmanagement.entities.Sitex}
 */
@Repository
public interface SitexRepository extends JpaRepository<Sitex, Long> {
    Sitex findSitexByIdSitex(Long idSitex);
}

package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Optional<Agence> findAgenceByCodeAgence(String codeAgence);
    void deleteBycodeAgence(String codeAgence);

    void deleteAgenceByCodeAgence(String codeAgence);

}

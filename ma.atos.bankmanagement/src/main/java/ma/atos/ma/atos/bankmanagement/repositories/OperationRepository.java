package ma.atos.ma.atos.bankmanagement.repositories;

import ma.atos.ma.atos.bankmanagement.entities.Agence;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}

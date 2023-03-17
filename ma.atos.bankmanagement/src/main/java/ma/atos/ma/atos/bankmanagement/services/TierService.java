package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;

import java.util.List;

/**
 * Service Layer for customer
 */
public interface TierService {

      /**
       *
       * @return
       */
      List<PersonneMoraleDto> getAllPersonneMorale();

      /**
       *
       * @param id
       * @return
       * @throws TierNotFoundExeption
       */
      PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption;

      /**
       *
       * @param personneMoraleDto
       * @return
       */
      PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto);

      /**
       *
       * @param id
       * @return
       */
      int deletPersonneMorale(long id);

      /**
       *
       * @return
       */
      List<PersonnePhysiqueDto> getAllPersonnePhysique();

      /**
       *
       * @param id
       * @return
       * @throws TierNotFoundExeption
       */
      PersonnePhysiqueDto getPersonnePhysique(Long id) throws TierNotFoundExeption;

      /**
       *
       * @param personnePhysiqueDto
       * @return
       */
      PersonnePhysiqueDto savePersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto);

      /**
       *
       * @param id
       * @return
       */
      int deletPersonnePhysique(long id);

}

package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;

import java.util.List;

public interface TierService {
    public List<PersonneMoraleDto> getAllPersonneMorale();
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption;
    public PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto);
    public void deletPersonneMorale(long id);

    //public TierDto getTier(long Id) throws TierNotFoundExeption;
}

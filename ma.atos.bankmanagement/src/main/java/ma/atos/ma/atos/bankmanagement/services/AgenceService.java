package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.mappers.AgenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AgenceService {
    private final AgenceMapper agenceMapper;
    @Autowired
    public AgenceService(AgenceMapper agenceMapper) {
        this.agenceMapper = agenceMapper;
    }
}


/*public class PersonService {
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public PersonDto createPerson(Person person) {
        return personMapper.personToPersonDto(person);
    }
}*/

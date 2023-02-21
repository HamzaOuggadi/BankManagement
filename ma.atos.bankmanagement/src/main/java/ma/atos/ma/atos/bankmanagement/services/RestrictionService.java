package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestrictionService implements RestrictionServiceInterface {
    @Autowired
    RestrictionRepository restrictionRepo;

    @Override
    public List<Restriction> getResctriction() {
        List<Restriction> Restriction = new ArrayList<>();
        restrictionRepo.findAll().forEach(Restriction::add);;
        return Restriction;
    }
    @Override
    public Restriction getRestricionById(Long idRestriction){
        return restrictionRepo.findById(idRestriction).get();
    }
    public Restriction createRestriction( Restriction restriction) {
        return restrictionRepo.save(restriction) ;
    }
    public void deleteRestriction(Long idRestriction){
        restrictionRepo.deleteById(idRestriction);
    }
}






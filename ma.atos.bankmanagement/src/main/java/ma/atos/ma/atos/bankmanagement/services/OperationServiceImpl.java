package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
//import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.entities.*;
//import ma.atos.ma.atos.bankmanagement.exceptions.CompteNotFoundException;
import ma.atos.ma.atos.bankmanagement.exceptions.CustomerException;
import ma.atos.ma.atos.bankmanagement.mappers.DepotMapper;
import ma.atos.ma.atos.bankmanagement.mappers.OperationMapper;
//import ma.atos.ma.atos.bankmanagement.mappers.PersonneMoraleMapper;
import ma.atos.ma.atos.bankmanagement.mappers.VirementMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.OperationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
//import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private VirementMapper virementMapper;
    @Autowired
    private DepotMapper depotMapper;
    @Autowired
    private MessageSource messageSource;


    @Override
    public List<OperationDto> getAllOperations() {
        List<Operation> operations = operationRepository.findAll();

        if (operations == null) {

            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);

        }

        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation operation : operations) {
            OperationDto operationDto = new OperationDto();
            BeanUtils.copyProperties(operation, operationDto);
            operationDtos.add(operationDto);
        }
        return operationDtos;

    }

    @Override
    public List<OperationDto> getOperationsByRibCompte(Long ribCompte) {

        Compte compte = compteRepository.findCompteByRibCompte(ribCompte);

        if (compte == null) {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        } else {
            List<Operation> operations = operationRepository.findByCompte_IdCompte(compte.getIdCompte());
            List<OperationDto> operationDtos = new ArrayList<>();
            for (Operation operation : operations) {
                OperationDto operationDto = new OperationDto();
                BeanUtils.copyProperties(operation, operationDto);
                operationDtos.add(operationDto);
            }
            return operationDtos;
        }
    }


    @Override
    public VirementDto createVirement(VirementDto virementDto) {

        Compte compteDestinateur = compteRepository.findByRibCompte(virementDto.getRibCompte());
        Compte compteDestinataire = compteRepository.findByRibCompte(Long.parseLong(virementDto.getRibCompteDestinataire()));

        if (compteDestinateur == null) {

            String msgError = messageSource.getMessage("account.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);

        }

        virementDto.getRibCompteDestinataire();
        Virement virement = virementMapper.virementDtoToVirement(virementDto);
        virement.setCompte(compteRepository.findCompteByRibCompte(virementDto.getRibCompte()));
        System.out.println(virement.getCompte());
        Virement saveVirement = operationRepository.save(virement);
        System.out.println(saveVirement);
        return virementMapper.virementToVirementDto(saveVirement);

    }

    @Override
    public DepotDto createDepot(DepotDto depotDto) {

//            Depot depot = new Depot();
//            BeanUtils.copyProperties(depotDto, depot);
        Compte compte = compteRepository.findByRibCompte(depotDto.getRibCompte());

        if (compte == null) {

            String msgError = messageSource.getMessage("account.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);

        }
        Depot depot = depotMapper.depotDtoToDepot(depotDto);

//          System.out.println(depotDto.getRibCompte());
        depot.setCompte(compteRepository.findCompteByRibCompte(depotDto.getRibCompte()));
        System.out.println(depot.getCompte());
        Depot saveDepot = operationRepository.save(depot);
        return depotMapper.depotToDepotDto(saveDepot);

    }

//    @Override
//    public OperationDto getOperationById(Long id) {
//
//        Operation operation = operationRepository.findById(id).get();
//
//        if (operation == null) {
//
//            String msgError = messageSource.getMessage("operation.not.found.message",
//                    new Object[]{}, Locale.getDefault());
//            throw new CustomerException(msgError);
//
//        }
//
//        return operationMapper.toDto(operation);
//    }

    @Override
    public OperationDto getOperationById(Long id) {

        Optional<Operation> optionalOperation = operationRepository.findById(id);

        if (optionalOperation.isPresent()) {
            Operation operation = optionalOperation.get();
            return operationMapper.toDto(operation);
        } else {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }
    }

    @Override
    public List<OperationDto> getOperationsByTypeOperation(String typeOperation) {

        if (typeOperation.equals("depot")) {
            List<Operation> operations = operationRepository.findByTypeOperation("depot");
            return operations.stream()
                    .map(operationMapper::toDto)
                    .collect(Collectors.toList());
        } else if (typeOperation.equals("virement")) {
            List<Operation> operations = operationRepository.findByTypeOperation("virement");
            return operations.stream()
                    .map(operationMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }
    }

    // Version 2 to creat OpertionDtà
    @Override
    public OperationDto createOperation(OperationDto operationDto) {

//            Compte compte = compteRepository.findByRibCompte(operationDto.getRibCompte());

//            if (compte == null) {
////                throw new EntityNotFoundException("Compte not found with RIB "
////                        + operationDto.getRibCompte());
//                throw new CompteNotFoundException("account.not.found.message",
//                        new Object[]{operationDto.getRibCompte()});
//            }

//           OperationDto result = new OperationDto();
//           Operation operation = operationMapper.toEntity(operationDto);
//           Operation operationCreated = operationRepository.save(operation);
//           return operationMapper.toDto(operationCreated);

        Optional<Compte> compte = compteRepository.findById(operationDto.getIdCompte());
//            if (!compte.isPresent()) {
////                throw new EntityNotFoundException("Compte not found with RIB "
////                        + operationDto.getRibCompte());
//                String msgError = messageSource.getMessage("operation.not.found.message",
//                        new Object[] {}, Locale.getDefault());
//                throw new CompteNotFoundException(msgError);
//            }

        OperationDto result = new OperationDto();
        Operation operation = operationMapper.toEntity(operationDto);
        operation.setCompte(compte.get());
        Operation operationCreated = null;
        if (operation.getTypeOperation().equals("depot")) {
            operationRepository.save((Depot) operation);
        } else {
            operationCreated = operationRepository.save((Virement) operation);
        }
        return operationMapper.toDto(operationCreated);

    }


    //        @Override
//        public List<OperationDto> getOperationsByRibCompte(Long ribCompte) {
//            Compte compte = compteRepository.findByRibCompte(ribCompte);
//            if (compte == null) {
//                throw new CompteNotFoundException("Account not Found with RIB " + ribCompte);
//            }else {
//
//            }
//
//        }

//        @Override
//        public List<OperationDto> getOperationsByCompte(Long idCompte) {
//            List<Operation> operations = operationRepository.findByCompte_IdCompte(idCompte);
//            return operations.stream()
//                    .map(operationMapper::toDto)
//                    .collect(Collectors.toList());
//        }

}









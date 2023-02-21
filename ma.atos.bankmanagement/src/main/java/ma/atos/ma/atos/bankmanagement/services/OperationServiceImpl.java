package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.mappers.OperationMapper;
import ma.atos.ma.atos.bankmanagement.repositories.OperationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService{

        @Autowired
        private OperationRepository operationRepository;
        @Autowired
        private OperationMapper operationMapper;

        @Override
        public List<OperationDto> getAllOperations() {

//            List<Operation> operations = operationRepository.findAll();
//            return operationMapper.toDtoList(operations);

                List<Operation> operations = operationRepository.findAll();
                List<OperationDto> operationDtos = new ArrayList<>();
                for (Operation operation : operations) {
                    OperationDto operationDto = new OperationDto();
                    BeanUtils.copyProperties(operation, operationDto);
                    operationDtos.add(operationDto);
                }
                return operationDtos;
        }

        @Override
        public List<OperationDto> getOperationsByCompte(Long idCompte) {
            List<Operation> operations = operationRepository.findByCompte_IdCompte(idCompte);
            return operations.stream()
                    .map(operationMapper::toDto)
                    .collect(Collectors.toList());
        }

        @Override
        public OperationDto createOperation(OperationDto operationDto) {
           OperationDto result = new OperationDto();
           Operation operation = operationMapper.toEntity(operationDto);
           Operation operationCreated = operationRepository.save(operation);
           return operationMapper.toDto(operationCreated);
        }

        @Override
        public OperationDto getOperationById(Long id) {
            Operation operation = operationRepository.findById(id).get();
            return operationMapper.toDto(operation);
        }


}







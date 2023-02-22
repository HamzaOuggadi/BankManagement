package ma.atos.ma.atos.bankmanagement;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;
import ma.atos.ma.atos.bankmanagement.repositories.OperationRepository;
import ma.atos.ma.atos.bankmanagement.services.CompteService;
import ma.atos.ma.atos.bankmanagement.services.OperationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//@Bean
//CommandLineRunner start(OperationServiceImpl operationService,
//						OperationRepository operationRepository,
//						CompteService compteService) {
//	return args -> {
//		for (int i=0; i<10; i++) {
//			CompteDto compteDto = new CompteDto();
//			compteDto.setRibCompte(i+123456789L);
//			compteDto.setBalance(Math.random()*100000);
//			compteDto.setDevise("MAD");
//			compteDto.setDateCreation(new Date());
//			compteDto.setTypeCompte(TypeCompte.COMPTE_COURANT);
//			compteService.createCompte(compteDto);
//		}
//	};
//}



	@Bean
	CommandLineRunner start(OperationServiceImpl operationService,
							OperationRepository operationRepository,
							CompteService compteService) {
		return args -> {
			for (int i=0; i<10; i++) {
				CompteDto compteDto = new CompteDto();
				OperationDto operationDto = new OperationDto();
				operationDto.setRibCompte(123456789L);
				operationDto.setMontant(Math.random()*100000);
				operationDto.setDateOperation(new Date());
				operationDto.setTypeOperation(String.valueOf(TypeCompte.COMPTE_COURANT));
				operationService.createOperation(operationDto);

			}
		};
	}





}

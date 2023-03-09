package ma.atos.ma.atos.bankmanagement;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
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
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Slf4j
public class Application {

	@Autowired
	TierService tierService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

@Bean
CommandLineRunner startCompte(OperationServiceImpl operationService,
						OperationRepository operationRepository,
						CompteService compteService) {
	return args -> {
		for (int i=0; i<10; i++) {
			CompteDto compteDto = new CompteDto();
			compteDto.setRibCompte(i+123456789L);
			log.info("itération : " + i + "rib : " + compteDto.getRibCompte());
			compteDto.setBalance(Math.random()*100000);
			compteDto.setDevise("MAD");
			compteDto.setDateCreation(new Date());
			compteDto.setTypeCompte(TypeCompte.COMPTE_COURANT);
			compteService.createCompte(compteDto);
		}
	};
}



/*	@Bean
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

	@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {

		//tierService.getAllPersonneMorale();
			//tierService.getPersonneMorale(12356777);

};}*//*
@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {

				PersonnePhysique personnePhysique=new PersonnePhysique();
			personnePhysique.setEmail("sdfghjikram");
			personnePhysique.setDateNaissance(new Date());
			personnePhysique.setTierType("PP");
				tierRepository.save(personnePhysique);


};}*/
	/*@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {
			tierService.getAllPersonneMorale();
			tierService.getPersonneMorale(Long.valueOf(1));
			tierService.deletPersonneMorale(1);

		};}*/
	/*@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {

			PersonneMorale personneMorale=new PersonneMorale();
			personneMorale.setRaionSociale("raisonSociale");
			personneMorale.setNumRegisterComm("sdfgbhnjk");
			personneMorale.setNationalite("moraco");
			tierRepository.save(personneMorale);
		};}*/
	/*@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {


			tierService.getAllPersonneMorale();


		};}*/
}

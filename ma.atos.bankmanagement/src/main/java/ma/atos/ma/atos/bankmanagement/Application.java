package ma.atos.ma.atos.bankmanagement;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;

import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;

import ma.atos.ma.atos.bankmanagement.services.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class Application {

	@Autowired
	RestrictionServiceImpl restrictionService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
@Bean
    CommandLineRunner start(RestrictionServiceImpl restrictionService,
						RestrictionRepository restrictionRepository ) {
	    return args -> {
		   for (int i=0; i<10; i++) {
			RestrictionDto restrictionDto = new RestrictionDto();
			restrictionDto.setEtat("les relevés bancaire sont bloqué");

		}
	};
}

/*
@Bean
	CommandLineRunner start(RestrictionServiceImpl restrictionService ){
		return args -> {
			restrictionService.getResctrictions();
		};
}


/*
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

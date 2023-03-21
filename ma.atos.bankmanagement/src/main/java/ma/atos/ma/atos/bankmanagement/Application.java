package ma.atos.ma.atos.bankmanagement;

import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;
import ma.atos.ma.atos.bankmanagement.mappers.CompteMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.OperationRepository;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.CompteService;
import ma.atos.ma.atos.bankmanagement.services.impl.OperationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner startCompte(OperationServiceImpl operationService,
								  OperationRepository operationRepository,
								  CompteService compteService,
								  TierRepository tierRepository,
								  CompteMapper compteMapper,
								  CompteRepository compteRepository) {
		return args -> {
			int min = 1;
			int max = 6;
			Random random = new Random();

			for (int i=0; i<2; i++) {
				Stream.of("Hamza", "Lisa", "Marie").forEach(cst-> {
					PersonnePhysique pp = new PersonnePhysique();
					pp.setNomComplet(cst);
					pp.setEmail(cst + "@gmail.com");
					pp.setDateNaissance(new Date());
					pp.setNumTel("0606060606"+ (int) (Math.random() * 100));
					pp.setNationalite("MAR");
					pp.setTypeIdentification("CIN");
					pp.setAdresse("Ville, Pays.");
					pp.setDateSouscription(new Date());
					pp.setNumClient("NC" + (random.nextLong() & Long.MAX_VALUE));

					tierRepository.save(pp);
				});
			}

			for (int i=0; i<10; i++) {
				CompteDto compteDto = new CompteDto();
				compteDto.setRibCompte(i+123456789L);
				log.info("itération : " + i + "rib : " + compteDto.getRibCompte());
				compteDto.setBalance(Math.round((Math.random()*100000)*100.0)/100.0);
				compteDto.setDevise("MAD");
				compteDto.setDateCreation(new Date());
				compteDto.setTypeCompte(TypeCompte.COMPTE_COURANT);
//			compteService.createCompte(compteDto);
				Compte compte = compteMapper.compteDtoToCompte(compteDto);
				compte.setTier(tierRepository.findById((long) random.nextInt(max - min + 1) + min).orElseThrow(()-> new TierNotFoundExeption("Not Found!")));
				compteRepository.save(compte);
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
	}*/


}

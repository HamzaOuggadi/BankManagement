package ma.atos.ma.atos.bankmanagement;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.services.CompteServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner start(CompteServiceImpl compteService,
							CompteRepository compteRepository) {
		return args -> {
			for (int i=0; i<10; i++) {
					CompteDto compteDto = new CompteDto();
					compteDto.setRibCompte(i+123456789L);
					compteDto.setBalance(Math.random()*100000);
					compteDto.setDevise("MAD");
					compteDto.setDateCreation(new Date());
					compteDto.setTypeCompte(TypeCompte.COMPTE_COURANT);
					compteService.createCompte(compteDto);
			}
		};
	}

}

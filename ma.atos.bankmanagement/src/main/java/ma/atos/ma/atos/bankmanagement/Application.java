package ma.atos.ma.atos.bankmanagement;
import ma.atos.ma.atos.bankmanagement.entities.PersonneMorale;
import ma.atos.ma.atos.bankmanagement.repositories.TierRepository;
import ma.atos.ma.atos.bankmanagement.services.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication

public class Application {

	@Autowired
	TierService tierService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*@Bean
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

	@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {

		//tierService.getAllPersonneMorale();
			//tierService.getPersonneMorale(12356777);

};}
/*@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {

				PersonneMorale personneMorale=new PersonneMorale();
				personneMorale.setRaionSociale("raisonSociale");
				tierRepository.save(personneMorale);


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
	@Bean
	CommandLineRunner start(TierRepository tierRepository) {
		return args -> {


			tierService.getAllPersonneMorale();


		};}
}

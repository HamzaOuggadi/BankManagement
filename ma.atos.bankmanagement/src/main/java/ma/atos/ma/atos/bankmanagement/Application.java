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

	}
	

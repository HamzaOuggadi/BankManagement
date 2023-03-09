package ma.atos.ma.atos.bankmanagement;

import ma.atos.ma.atos.bankmanagement.services.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@SpringBootApplication
@EnableEurekaClient
public class Application {

	@Autowired
	RestrictionServiceImpl restrictionService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}

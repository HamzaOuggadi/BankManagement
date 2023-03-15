package ma.atos.ma.atos.bankmanagement.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties("vault")
@Data
public class Credential {

    private String username;
    private String password;
}

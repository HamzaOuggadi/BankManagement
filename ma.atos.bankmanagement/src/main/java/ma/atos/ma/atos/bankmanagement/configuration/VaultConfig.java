package ma.atos.ma.atos.bankmanagement.configuration;

import static org.springframework.vault.core.lease.domain.RequestedSecret.Mode.RENEW;
import static org.springframework.vault.core.lease.domain.RequestedSecret.Mode.ROTATE;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.lease.SecretLeaseContainer;
import org.springframework.vault.core.lease.event.*;

import com.zaxxer.hikari.HikariDataSource;

import javax.annotation.PostConstruct;


@Configuration
public class VaultConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecretLeaseContainer leaseContainer;

    @Autowired
    private HikariDataSource hikariDataSource;

    @Value("${spring.cloud.vault.database.role}")
    private String databaseRole;

    @PostConstruct
    private void postConstruct(){
        String path = "database/creds/" + databaseRole;
        logger.info("outside the event listener");
        leaseContainer.addLeaseListener(event -> {
            logger.info("inside the event listener");
            if (!path.equals(event.getSource().getPath())) {
                logger.info("inside the 1st if statement");
                return;
            }else{
                logger.info("inside the 1st else statement : "+event.getSource().getPath());
            }//else is of no use

            if (event instanceof SecretLeaseExpiredEvent && RENEW == event.getSource().getMode()) {
                logger.info("inside the 2nd if statement");
                logger.info("Replace RENEW for expired credential with ROTATE");
                leaseContainer.requestRotatingSecret(path);
            }else{
                logger.info("inside the 2nd else statement : "+event.getSource().getMode());
            }

            if (event instanceof SecretLeaseCreatedEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 3rd if statement");
                Map<String, Object> secrets = ((SecretLeaseCreatedEvent) event).getSecrets();
                String username = (String) secrets.get("username");
                String password = (String) secrets.get("password");
                logger.info("Current user = {}, {}", username,password);
                hikariDataSource.getHikariConfigMXBean().setUsername(username);
                hikariDataSource.getHikariConfigMXBean().setPassword(password);
                logger.info("Soft evicting db connections...");
                hikariDataSource.getHikariPoolMXBean().softEvictConnections();
            }else{
                logger.info("inside the 3rd else statement : "+event.getSource().getMode());
            }
            if (event instanceof SecretLeaseRotatedEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 4th if statement");
            }else{
                logger.info("inside the 4th else statement : "+event.getSource().getMode());
            }
            if (event instanceof SecretLeaseEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 5th if statement");
            }else{
                logger.info("inside the 5th else statement : "+event.getSource().getMode());
            }
            if (event instanceof SecretLeaseErrorEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 6th if statement");
            }else{
                logger.info("inside the 6th else statement : "+event.getSource().getMode());
            }
            if (event instanceof AfterSecretLeaseRenewedEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 7th if statement");
            }else{
                logger.info("inside the 7th else statement : "+event.getSource().getMode());
            }
            if (event instanceof AfterSecretLeaseRevocationEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 8th if statement");
            }else{
                logger.info("inside the 8th else statement : "+event.getSource().getMode());
            }
            if (event instanceof BeforeSecretLeaseRevocationEvent && ROTATE == event.getSource().getMode()) {
                logger.info("inside the 9th if statement");
            }else{
                logger.info("inside the 9th else statement : "+event.getSource().getMode());
            }
        });
    }

}
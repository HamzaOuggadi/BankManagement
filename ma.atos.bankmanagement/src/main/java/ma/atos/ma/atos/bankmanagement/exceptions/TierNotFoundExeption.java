package ma.atos.ma.atos.bankmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class TierNotFoundExeption extends Exception {

    public TierNotFoundExeption(String message) {
        super(message);
    }
}

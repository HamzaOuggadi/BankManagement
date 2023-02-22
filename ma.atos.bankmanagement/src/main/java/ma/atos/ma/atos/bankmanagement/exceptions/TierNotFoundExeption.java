package ma.atos.ma.atos.bankmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class TierNotFoundExeption extends Exception {
    private String message;
    private String code;
    private HttpStatus httpStatus;
    public TierNotFoundExeption(String message) {
        super(message);
    }



}

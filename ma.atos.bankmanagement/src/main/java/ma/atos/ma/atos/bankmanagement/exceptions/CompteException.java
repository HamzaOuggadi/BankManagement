package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class CompteException extends Exception {

    private String message;
    private String messageFront;
    private String code;
    private HttpStatus httpStatus;
    public CompteException(String message) {
        super();
        this.message = message;
    }

    public CompteException(String message, String messageFront , String code) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
    }

    public CompteException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}

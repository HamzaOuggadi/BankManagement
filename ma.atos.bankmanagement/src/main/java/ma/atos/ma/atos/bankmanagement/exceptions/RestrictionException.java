package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Setter;
import org.springframework.http.HttpStatus;


@Setter
public class RestrictionException extends RuntimeException{
    private String message;
    private String code;
    private HttpStatus httpStatus;

    public RestrictionException(String message){
        super();
        this.message=message;
    }
    public RestrictionException(String message,HttpStatus httpStatus){
        super();
        this.message=message;
        this.httpStatus= httpStatus;
    }
    public RestrictionException(String message, String code, HttpStatus httpStatus){
        super();
        this.message=message;
        this.code=code;
        this.httpStatus= httpStatus;
    }
    }



package ma.atos.ma.atos.bankmanagement.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class GestionnaireException extends RuntimeException{
    private String message;
    private String code;
    private HttpStatus httpStatus;
    public GestionnaireException(String message){
        super(message);
    }
    public GestionnaireException(String message, HttpStatus httpStatus){
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }
    public GestionnaireException(String message, String code){
        super();
        this.message=message;
        this.code = code;
    }
    public GestionnaireException(String message,String code, HttpStatus httpStatus){
        super();
        this.message = message;
        this.code = code ;
        this.httpStatus = httpStatus;
    }


}

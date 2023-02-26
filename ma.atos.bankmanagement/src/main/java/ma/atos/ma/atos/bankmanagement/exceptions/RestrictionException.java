package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestrictionException extends RuntimeException{
    private String message;
    private String code;
    public RestrictionException(String message){
        super();
        this.message=message;
    }

}

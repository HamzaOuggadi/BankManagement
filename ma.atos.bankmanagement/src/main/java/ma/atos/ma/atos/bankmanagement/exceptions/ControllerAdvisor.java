package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.extern.log4j.Log4j2;
import ma.atos.ma.atos.bankmanagement.dtos.responses.ErrorStatus;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
        public ResponseEntity<GenericResponse> handleException(Exception e) {
            GenericResponse result = new GenericResponse();

            log.error(e.getMessage(), e);
            e.printStackTrace();
            result.setStatusCode(String.valueOf(ErrorStatus.TECHNICAL_ERROR.getCode()));
            result.setDescription(ErrorStatus.TECHNICAL_ERROR.description());

             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(TierNotFoundExeption.class)
    public ResponseEntity<GenericResponse> handleException(TierNotFoundExeption ex){
        GenericResponse result = new GenericResponse();
        log.error(ex.getMessage(), ex);
        ex.printStackTrace();
        result.setStatusCode(ex.getCode());
        result.setDescription(ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ExceptionHandler(RestrictionException.class)
    public ResponseEntity<GenericResponse> handleRestrictionException(RestrictionException ex){
            GenericResponse result = new GenericResponse();
            log.error(ex.getMessage(), ex);
            ex.printStackTrace();
            result.setDescription(ex.getMessage());
            result.setStatusCode(ex.getCode());
            return ResponseEntity.status(ex.getHttpStatus()).body(result);
    }


    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<GenericResponse> handleCustomerException(CustomerException ex) {
        GenericResponse result = new GenericResponse();
        result.setDescriptionForOperation(ex.getMessage());
        result.setError(true);
        result.setDescription(ex.getMessage());
        result.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @ExceptionHandler(CompteException.class)
    public ResponseEntity<GenResponse> handleCompteException(CompteException e) {
            GenResponse response = new GenResponse();
            log.error(e.getMessage());
            e.printStackTrace();
            response.setError(true);
            response.setDescription(e.getMessage());
            response.setDescriptionFront(e.getMessageFront());
            response.setApiStatusCode(e.getCode());
            return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

    @ExceptionHandler(GestionnaireException.class)
    public ResponseEntity<GenericResponse> handleGestionnaireException(GestionnaireException exp){
         GenericResponse response = new GenericResponse();
         log.error(exp.getMessage(),exp);
         exp.printStackTrace();
         response.setDescription(exp.getMessage());
         response.setStatusCode(exp.getCode());
         return ResponseEntity.status(exp.getHttpStatus()).body(response);

    }

}

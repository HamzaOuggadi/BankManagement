package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.extern.log4j.Log4j2;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.ErrorStatus;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
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





}

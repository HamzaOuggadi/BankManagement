package ma.atos.ma.atos.bankmanagement.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice

@Log4j2

public class ControllerAdvice extends ResponseEntityExceptionHandler {


}

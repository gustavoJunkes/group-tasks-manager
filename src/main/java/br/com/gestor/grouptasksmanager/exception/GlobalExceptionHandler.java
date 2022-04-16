package br.com.gestor.grouptasksmanager.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidPasswordException.class, PropertyAlreadyInUseException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handler(Exception ex, WebRequest request){
        return new ResponseEntity<>("Sistem error. " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        // TODO: 15/04/2022 validate for IllegalArgumentException, passing its message to the response
        // TODO: 15/04/2022 validate the response for each exception
    }


}

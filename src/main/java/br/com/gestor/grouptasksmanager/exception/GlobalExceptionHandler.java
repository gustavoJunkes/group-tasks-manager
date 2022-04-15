package br.com.gestor.grouptasksmanager.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidPasswordException.class, NicknameAlreadyInUseException.class})
    public ResponseEntity<String> handler(Exception ex, WebRequest request){
        return new ResponseEntity<>("Sistem error. " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}

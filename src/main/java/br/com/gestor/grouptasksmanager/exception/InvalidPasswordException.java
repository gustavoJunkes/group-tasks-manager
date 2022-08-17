package br.com.gestor.grouptasksmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given nickname is already in use")
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message){
        super(message);
    }
}

package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.exception.InvalidPasswordException;
import br.com.gestor.grouptasksmanager.exception.PropertyAlreadyInUseException;
import br.com.gestor.grouptasksmanager.model.user.dto.SingupDto;
import br.com.gestor.grouptasksmanager.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<SingupDto> singUp(@RequestBody SingupDto user) {
       return new ResponseEntity<>(userService.singUp(user), HttpStatus.CREATED);
    }
}

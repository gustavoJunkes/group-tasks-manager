package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.exception.InvalidPasswordException;
import br.com.gestor.grouptasksmanager.exception.PropertyAlreadyInUseException;
import br.com.gestor.grouptasksmanager.model.user.dto.SingupDto;
import br.com.gestor.grouptasksmanager.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/singup")
    public ResponseEntity<SingupDto> singUp(@RequestBody SingupDto user) throws PropertyAlreadyInUseException, InvalidPasswordException {
       return new ResponseEntity<>(userService.singUp(user), HttpStatus.CREATED);
    }
}

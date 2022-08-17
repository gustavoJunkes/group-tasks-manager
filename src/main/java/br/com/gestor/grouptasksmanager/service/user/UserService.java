package br.com.gestor.grouptasksmanager.service.user;

import br.com.gestor.grouptasksmanager.exception.InvalidPasswordException;
import br.com.gestor.grouptasksmanager.exception.PropertyAlreadyInUseException;
import br.com.gestor.grouptasksmanager.model.user.User;
import br.com.gestor.grouptasksmanager.model.user.dto.SingupDto;
import br.com.gestor.grouptasksmanager.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        user.setId(null);
        return userRepository.save(user);
    }

    // TODO: 16/04/2022 solve the throwable issue here, this exceptions may dont need to be dealed with
    public SingupDto singUp(SingupDto user) throws InvalidPasswordException, PropertyAlreadyInUseException {
        user.id = null;
        User newUser = User.builder()
                .firstName(user.firstName)
                .lastName(user.lastName)
                .nickname(user.nickname)
                .login(user.login)
                .password(user.password)
                .build();
        canRegister(newUser);
        newUser = userRepository.save(newUser);
        return SingupDto.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .nickname(newUser.getNickname())
                .login(newUser.getLogin())
                .password(newUser.getPassword()).id(newUser.getId())
                .build();
    }

    private void canRegister(User user) throws PropertyAlreadyInUseException, InvalidPasswordException {

        if ( user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidPasswordException("The given password is not valid");
        }

        if(nicknameExists(user.getNickname())){
            throw new PropertyAlreadyInUseException("Nickname already in use");
        } else if(loginAlreadyExists(user.getLogin())){
            throw new PropertyAlreadyInUseException("Login already in use");
        }
    }

    private boolean nicknameExists(String nickname){
        return userRepository.existsByNickname(nickname);
    }

    private boolean loginAlreadyExists(String login){
        return userRepository.existsByLogin(login);
    }
}



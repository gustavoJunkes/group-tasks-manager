package br.com.gestor.grouptasksmanager.service.user;

import br.com.gestor.grouptasksmanager.exception.InvalidPasswordException;
import br.com.gestor.grouptasksmanager.exception.NicknameAlreadyInUseException;
import br.com.gestor.grouptasksmanager.model.user.PermissionEnum;
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

    public SingupDto singUp(SingupDto user) throws NicknameAlreadyInUseException, InvalidPasswordException {

        User newUser = User.builder()
                .nickname(user.nickname)
                .login(user.login)
                .password(user.password)
                .permissionEnum(PermissionEnum.NORMAL)
                .build();
        canRegister(newUser);
        userRepository.save(newUser);
        return SingupDto.builder()
                .nickname(newUser.getNickname())
                .login(newUser.getLogin())
                .password(newUser.getPassword())
                .build();
    }

    private void canRegister(User user) throws NicknameAlreadyInUseException, InvalidPasswordException {

        if ( user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidPasswordException("The given password is not valid");
        }

        if(nickNameExists(user.getNickname())){
            throw new NicknameAlreadyInUseException("Nickname already in use");
        }
    }

    private boolean nickNameExists(String nickname){
        return userRepository.findAllByNickname(nickname);
    }
}



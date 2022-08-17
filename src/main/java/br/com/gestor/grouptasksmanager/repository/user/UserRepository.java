package br.com.gestor.grouptasksmanager.repository.user;

import br.com.gestor.grouptasksmanager.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean findAllByNickname(String nickname);

}

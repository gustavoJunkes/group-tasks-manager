package br.com.gestor.grouptasksmanager.repository.user;

import br.com.gestor.grouptasksmanager.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select case when count(u) > 0 then true else false end from usu u where u.nickname = :nickname ")
    boolean existsByNickname(@Param("nickname") String nickname);

    @Query("select case when count(u) > 0 then true else false end from usu u where u.login = :login ")
    boolean existsByLogin(@Param("login") String login);
}

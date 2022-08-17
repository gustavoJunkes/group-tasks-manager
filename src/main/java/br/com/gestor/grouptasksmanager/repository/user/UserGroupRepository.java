package br.com.gestor.grouptasksmanager.repository.user;

import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}

package br.com.gestor.grouptasksmanager.repository.group;

import br.com.gestor.grouptasksmanager.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

}

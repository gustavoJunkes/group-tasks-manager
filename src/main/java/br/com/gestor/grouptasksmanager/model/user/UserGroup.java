package br.com.gestor.grouptasksmanager.model.user;

import br.com.gestor.grouptasksmanager.model.group.Group;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "user_group")
@Data
@Builder
public class UserGroup {

    @Id
    private Long id;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private PermissionEnum permission;

}

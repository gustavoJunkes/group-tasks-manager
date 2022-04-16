package br.com.gestor.grouptasksmanager.model.group;

import br.com.gestor.grouptasksmanager.model.task.Task;
import br.com.gestor.grouptasksmanager.model.user.User;
import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Builder
public class Group {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany
    private List<UserGroup> users;

    @OneToMany
    private List<Task> tasks;

    @ManyToOne
    public User groupCreator;

    private String groupName;


}

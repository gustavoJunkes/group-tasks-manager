package br.com.gestor.grouptasksmanager.model.group;

import br.com.gestor.grouptasksmanager.model.task.Task;
import br.com.gestor.grouptasksmanager.model.user.User;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

public class Group {

    @Id
    private UUID id;

    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Task> tasks;

    private String groupName;


}

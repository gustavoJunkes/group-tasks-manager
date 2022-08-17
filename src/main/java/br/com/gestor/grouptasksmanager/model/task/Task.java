package br.com.gestor.grouptasksmanager.model.task;

import br.com.gestor.grouptasksmanager.model.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Task {

    @Id
    private UUID id;

    @ManyToOne
    private User owner;

}

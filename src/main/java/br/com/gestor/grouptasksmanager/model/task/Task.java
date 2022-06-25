package br.com.gestor.grouptasksmanager.model.task;

import br.com.gestor.grouptasksmanager.model.group.Group;
import br.com.gestor.grouptasksmanager.model.user.User;
import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //refers to the user in the group that is responsable for this task
    @ManyToOne
    private UserGroup user;

    @ManyToOne
    @NotNull
    private Group group;

    @NotNull
    @NotBlank
    @NotEmpty
    private String description;

    @NotNull
    @NotBlank
    @NotEmpty
    private String title;

    //how long to the task repeat again (in days)
    private double repeatIn;

    // how much times the task will be repeated
    private int repeatTimes;

}

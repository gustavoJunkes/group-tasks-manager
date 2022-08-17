package br.com.gestor.grouptasksmanager.model.task.dto;

import br.com.gestor.grouptasksmanager.model.group.Group;
import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {

    public Long id;
    public UserGroup user;
    public Group group;
    public String title;
    public String description;
    public double repeatIn;
    public int repeatTimes;

}

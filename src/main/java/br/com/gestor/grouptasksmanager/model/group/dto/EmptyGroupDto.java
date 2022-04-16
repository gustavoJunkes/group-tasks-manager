package br.com.gestor.grouptasksmanager.model.group.dto;

import br.com.gestor.grouptasksmanager.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmptyGroupDto {

    public UUID id;

    public String groupName;

    public User groupCreator;

}

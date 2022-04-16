package br.com.gestor.grouptasksmanager.service.group;

import br.com.gestor.grouptasksmanager.model.group.Group;
import br.com.gestor.grouptasksmanager.model.group.dto.EmptyGroupDto;
import br.com.gestor.grouptasksmanager.model.user.PermissionEnum;
import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import br.com.gestor.grouptasksmanager.repository.group.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public EmptyGroupDto registerNewEmptyGroup(EmptyGroupDto group){
        group.id = null;

        if (group.groupCreator == null){
            throw new IllegalArgumentException("The group must have a creator user.");
        }
        Group newGroup = Group.builder().groupCreator(group.groupCreator).groupName(group.groupName).build();
        newGroup.getGroupCreator();
        // Add the creator to the list of users with manager permission
        newGroup.getUsers().add(UserGroup.builder().permission(PermissionEnum.MANAGER).user(newGroup.groupCreator).build());

        newGroup = groupRepository.save(newGroup);

        return EmptyGroupDto.builder().groupCreator(newGroup.groupCreator).groupName(newGroup.getGroupName()).id(newGroup.getId()).build();
    }

}

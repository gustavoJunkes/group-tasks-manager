package br.com.gestor.grouptasksmanager.service.group;

import br.com.gestor.grouptasksmanager.model.group.Group;
import br.com.gestor.grouptasksmanager.model.group.dto.EmptyGroupDto;
import br.com.gestor.grouptasksmanager.model.user.PermissionEnum;
import br.com.gestor.grouptasksmanager.model.user.UserGroup;
import br.com.gestor.grouptasksmanager.repository.group.GroupRepository;
import br.com.gestor.grouptasksmanager.repository.user.UserGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    public EmptyGroupDto registerNewEmptyGroup(EmptyGroupDto group){
        group.id = null;

        if (group.groupCreator == null){
            throw new IllegalArgumentException("The group must have a creator user.");
        }
        Group newGroup = Group.builder().groupCreator(group.groupCreator).groupName(group.groupName).users(new ArrayList<>()).build();
        // TODO: 16/04/2022 to verify if the group name is avaliable before register it
        UserGroup groupCreator = UserGroup.builder().permission(PermissionEnum.MANAGER).user(newGroup.groupCreator).build();
        userGroupRepository.saveAndFlush(groupCreator);
        // Add the creator to the list of users with manager permission
        newGroup.getUsers().add(groupCreator);

        newGroup = groupRepository.save(newGroup);

        return EmptyGroupDto.builder().groupCreator(newGroup.groupCreator).groupName(newGroup.getGroupName()).id(newGroup.getId()).build();
    }

}

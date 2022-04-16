package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.model.group.dto.EmptyGroupDto;
import br.com.gestor.grouptasksmanager.service.group.GroupService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    public ResponseEntity<EmptyGroupDto> newEmptyGroup(@RequestBody EmptyGroupDto group){
        group = groupService.registerNewEmptyGroup(group);
        return new ResponseEntity(group, HttpStatus.CREATED);
    }


}

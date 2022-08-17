package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.model.group.dto.EmptyGroupDto;
import br.com.gestor.grouptasksmanager.service.group.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/group")
@RestController
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/newGroup")
    public ResponseEntity<EmptyGroupDto> newGroup(@RequestBody EmptyGroupDto group){
        group = groupService.registerNewEmptyGroup(group);
        return new ResponseEntity(group, HttpStatus.CREATED);
    }


}

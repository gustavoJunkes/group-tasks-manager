package br.com.gestor.grouptasksmanager.controller;

import br.com.gestor.grouptasksmanager.model.task.dto.TaskDto;
import br.com.gestor.grouptasksmanager.service.task.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/task")
@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/registerNewTask")
    public ResponseEntity<TaskDto> registerNewTask(@RequestBody @Valid TaskDto task) {
        return new ResponseEntity<>(taskService.registerNewTask(task), HttpStatus.CREATED);
    }
}
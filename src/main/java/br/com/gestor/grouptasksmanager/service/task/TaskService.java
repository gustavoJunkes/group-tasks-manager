package br.com.gestor.grouptasksmanager.service.task;

import br.com.gestor.grouptasksmanager.model.group.Group;
import br.com.gestor.grouptasksmanager.model.task.Task;
import br.com.gestor.grouptasksmanager.model.task.dto.TaskDto;
import br.com.gestor.grouptasksmanager.repository.group.GroupRepository;
import br.com.gestor.grouptasksmanager.repository.task.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final GroupRepository groupRepository;

    public TaskDto registerNewTask(TaskDto task){
        task.id = null;

        Task newTask = Task.builder()
                .user(task.user)
                .group(task.group)
                .title(task.title)
                .description(task.description)
                .repeatIn(task.repeatIn)
                .repeatTimes(task.repeatTimes)
                .build();

        Group group = groupRepository.findById(task.getGroup().getId())
                .orElseThrow(() -> new IllegalArgumentException("The given group does not exist: "+ task.getGroup().getId()));

        newTask = taskRepository.save(newTask);
        group.getTasks().add(newTask);
        groupRepository.save(group);

        return TaskDto.builder()
                .user(newTask.getUser())
                .group(newTask.getGroup())
                .title(newTask.getTitle())
                .description(newTask.getDescription())
                .repeatIn(newTask.getRepeatIn())
                .repeatTimes(newTask.getRepeatTimes())
                .build();
    }

}

package br.com.gestor.grouptasksmanager.repository.task;

import br.com.gestor.grouptasksmanager.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

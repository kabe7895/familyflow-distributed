package de.familyflow.backend.task;

import de.familyflow.backend.task.dto.TaskRequestDTO;
import de.familyflow.backend.task.dto.TaskResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {


    private final TaskRepository repository;


    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public List<TaskResponseDTO> getAllTasks() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public TaskResponseDTO getTaskById(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        return mapToDTO(task);
    }


    public TaskResponseDTO createTask(TaskRequestDTO request) {

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(false);

        Task saved = repository.save(task);

        return mapToDTO(saved);
    }


    public TaskResponseDTO updateTask(
            Long id,
            TaskRequestDTO request
    ) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));


        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());


        Task saved = repository.save(task);

        return mapToDTO(saved);
    }


    public void deleteTask(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        repository.delete(task);
    }


    private TaskResponseDTO mapToDTO(Task task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }
}
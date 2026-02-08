package com.fullstack.TaskManagement.service;

import com.fullstack.TaskManagement.entity.Task;
import com.fullstack.TaskManagement.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getTasks(){return taskRepository.findAll();}
    public Optional <Task> getTaskById(Long Id) {return taskRepository.findById(Id);}
    public Task addtask(Task task) {
        return taskRepository.save(task);
    }
    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

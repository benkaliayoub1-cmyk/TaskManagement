package com.fullstack.TaskManagement.service;


import com.fullstack.TaskManagement.entity.Task;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
@Service
public class TaskServiceDao {
    private TaskService taskService;

    public List<Task> getTasks() {  return taskService.getTasks();}
    public Optional<?> getTask(Long Id) {
        return Optional.of(taskService.getTaskById(Id).
                orElseThrow(
                        () -> new EntityNotFoundException("Requested Task not Found")
                ));
    }
    public Task addtask(Task task) {
        return taskService.addtask(task);
    }

    public ResponseEntity<?> updatetask(Task task , Long id) {
        if(taskService.existsById(id)){
            Task task1 = taskService.getTaskById(id).
                    orElseThrow(
                            ()->new EntityNotFoundException("Requested task Not found!!")
                    );
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setType(task.getType());
            task1.setDueDate(task.getDueDate());
            taskService.addtask(task1);
            // returned type Task
            return ResponseEntity.ok().body(task1);
        }
        else {
            HashMap<String , String> message = new HashMap<>();
            message.put("message" , id + "task not found or matched");
            // returned type HashMap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    public ResponseEntity<?> deletetask (Long id) {
        if (taskService.existsById(id)) {
            taskService.deleteTask(id);
            HashMap<String , String> message = new HashMap<>();
            message.put("message " , "task with id " + id +" "+ "deleted successfully ." );
            // returned type HashMap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else {
            HashMap<String , String> message = new HashMap<>();
            message.put("message" , id + "task not found or matched");
            // returned type HashMap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}

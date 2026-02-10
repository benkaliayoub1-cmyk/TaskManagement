package com.fullstack.TaskManagement.controller;



import com.fullstack.TaskManagement.entity.Task;
import com.fullstack.TaskManagement.service.TaskServiceDao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class TaskController {
      private TaskServiceDao dao;



    @GetMapping("/task")
    public List<Task> getTasks() {  return dao.getTasks();}

    @GetMapping("/task/{id}")
    public Optional<?> getTask(@PathVariable Long id) {
        return dao.getTask(id);
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {
        return dao.addtask(task);
    }

    @PutMapping("/task/{id}")
        public ResponseEntity<?> updatetask(@RequestBody Task task , @PathVariable Long id) {
        return dao.updatetask(task , id);
    }
    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask (@PathVariable Long id) {
      return dao.deletetask(id);
    }
}

package com.fullstack.TaskManagement.repository;

import com.fullstack.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

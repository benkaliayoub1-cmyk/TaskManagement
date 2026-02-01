package com.fullstack.TaskManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor // to create Consturctor without writing it down
@AllArgsConstructor
@Data // to create Getters and Setters without writing them down
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    private String title;
    private String description;
    private String type;
    private Date dueDate;
}

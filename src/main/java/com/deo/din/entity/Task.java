package com.deo.din.entity;

import com.deo.din.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Name needed")
    private String name;
    @NotBlank(message = "Message needed")
    private String text;

    private String tag;

    private boolean isComplete;


    public TaskStatus taskStatus;


    public Task(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Task(String name, String text, TaskStatus taskStatus, boolean isComplete) {
        this.name = name;
        this.text = text;
        this.taskStatus = taskStatus;
        this.isComplete= isComplete;
    }

    public Task(String name, String text, String tag, boolean isComplete) {
        this.name = name;
        this.text = text;
        this.tag = tag;
        this.isComplete= isComplete;
    }
}

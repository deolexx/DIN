package com.deo.din.entity;

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




    public Task(String name, String text) {
        this.name = name;
        this.text = text;
    }
}

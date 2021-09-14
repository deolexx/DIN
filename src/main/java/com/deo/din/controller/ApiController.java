package com.deo.din.controller;

import com.deo.din.repository.TaskRepository;
import com.deo.din.entity.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ApiController {

    TaskRepository taskRepo;

    public ApiController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/api")
   public  ArrayList<Task>  getAllTasks(){
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Learn Java","Type some code"));
        tasks.add(new Task("Do some exercises","make 10 pullups"));
        tasks.add(new Task("Read English","news maybe"));

        return tasks;
    }


}

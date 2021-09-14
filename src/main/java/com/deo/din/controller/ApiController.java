package com.deo.din.controller;

import com.deo.din.entity.Task;
import com.deo.din.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    TaskRepository taskRepo;



    @GetMapping("/api")
   public Iterable<Task> getAllTasks(){
        Iterable<Task> all = taskRepo.findAll();

        return all;
    }


}

package com.deo.din.controller;

import com.deo.din.entity.Task;
import com.deo.din.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepo;



    @GetMapping("/web")
    public String getAllTasksWeb(Model model){
        var tasksFromDB = taskRepo.findAll();
        model.addAttribute("tasks",tasksFromDB);
        return "index";
    }


    @PostMapping("/web")
    public String createNewTask(@RequestParam String taskName, @RequestParam String taskText, Model model){
        Task task = new Task(taskName,taskText);
        taskRepo.save(task);
        var tasksFromDB = taskRepo.findAll();
        model.addAttribute("tasks",tasksFromDB);

        return "index";
    }

}

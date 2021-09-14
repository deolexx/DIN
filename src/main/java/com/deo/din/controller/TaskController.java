package com.deo.din.controller;

import com.deo.din.entity.Task;
import com.deo.din.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepo;


    @GetMapping("main")
    public String getAllTasksWeb(Model model) {
        var tasksFromDB = taskRepo.findAll();
        model.addAttribute("tasks", tasksFromDB);
        return "index";
    }


    @PostMapping("main")
    public String createNewTask(@RequestParam String taskName, @RequestParam String taskText, @RequestParam(required = false, defaultValue = "") String tag, Model model) {
        Task task = new Task(taskName, taskText, tag);
        taskRepo.save(task);
        var tasksFromDB = taskRepo.findAll();
        model.addAttribute("tasks", tasksFromDB);

        return "index";
    }

    @PostMapping("filter")
    public String filter(@RequestParam(defaultValue = "") String filter, Model model) {

        Iterable<Task> byTag;


        if (filter != null && filter.isBlank()) {
            byTag = taskRepo.findAll();

        } else {
            byTag = taskRepo.findByTag(filter);
        }

        model.addAttribute("tasks", byTag);
        return "index";
    }

}

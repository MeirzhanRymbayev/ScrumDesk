package com.epam.scrumdesk.controller;

import com.epam.scrumdesk.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id) {
        Task currentTask = taskService.findById(id);
        taskService.updateTask(currentTask);
    }
}

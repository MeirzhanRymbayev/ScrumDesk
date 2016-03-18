package com.epam.scrumdesk.controller;

import com.epam.scrumdesk.model.Task;
import com.epam.scrumdesk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    TaskService taskService;


    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        Task currentTask = taskService.findById(id);

        if (currentTask == null) {
            //TODO Logger
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentTask.setText(task.getText());
        currentTask.setStatus(task.getStatus());


        taskService.updateTask(currentTask);

        return new ResponseEntity<>(currentTask, HttpStatus.OK);
    }
}

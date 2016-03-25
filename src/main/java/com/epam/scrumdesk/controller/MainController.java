package com.epam.scrumdesk.controller;

import com.epam.scrumdesk.model.Task;
import com.epam.scrumdesk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    TaskService taskService;

    /*--------------------------------Retrieve all tasks---------------------------------------*/
    @RequestMapping(value = "/task/", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> listAllTasks() {
        List<Task> tasks = taskService.findAllUsers();
        if (tasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /*--------------------------------Update a task--------------------------------------------*/
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

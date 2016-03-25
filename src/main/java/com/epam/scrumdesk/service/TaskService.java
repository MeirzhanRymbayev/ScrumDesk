package com.epam.scrumdesk.service;

import com.epam.scrumdesk.model.Task;

import java.util.List;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
public interface TaskService {
    Task findById(long id);

    void updateTask(Task task);

    List<Task> findAll();
}

package com.epam.scrumdesk.service;

import com.epam.scrumdesk.model.Task;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
public interface TaskService {
    Task findById(long id);

    void updateTask(Task task);

}

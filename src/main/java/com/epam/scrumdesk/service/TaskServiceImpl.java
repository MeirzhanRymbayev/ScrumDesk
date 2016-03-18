package com.epam.scrumdesk.service;

import com.epam.scrumdesk.model.Task;
import org.springframework.stereotype.Service;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {


    @Override
    public Task findById(long id) {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }
}

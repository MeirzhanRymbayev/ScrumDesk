package com.epam.scrumdesk.service;

import com.epam.scrumdesk.dao.TaskDao;
import com.epam.scrumdesk.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskDao taskDao;

    @Override
    public Task findById(long id) {
        return (Task) taskDao.findById(id);
    }

    @Override
    public void updateTask(Task task) {
        taskDao.update(task);
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

}

package com.epam.scrumdesk.dao;

import com.epam.scrumdesk.model.Task;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
public interface TaskDao {
    Task fingById(long id);

    void save(Task task);

    void update(Task task);


}

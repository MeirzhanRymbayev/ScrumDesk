package com.epam.scrumdesk.dao;

import com.epam.scrumdesk.model.Task;

import java.util.List;


public interface TaskDao<T> {

    T findById(long id);

    void save(T t);

    void update(T t);

    List<Task> findAll();
}

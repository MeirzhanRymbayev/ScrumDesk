package com.epam.scrumdesk.dao;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
public interface TaskDao<T> {

    T findById(long id);

    void save(T t);

    void update(T t);

}

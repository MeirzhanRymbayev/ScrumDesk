package com.epam.scrumdesk.dao;

import com.epam.scrumdesk.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
@Repository
public class TaskDaoImpl implements  TaskDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Task fingById(long id) {
        Session session = sessionFactory.getCurrentSession();
         return (Task) session.get(Task.class, id);
    }

    @Override
    public void save(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.save(task);
    }

    @Override
    public void update(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }
}

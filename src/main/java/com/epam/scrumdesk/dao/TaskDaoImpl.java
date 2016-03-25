package com.epam.scrumdesk.dao;

import com.epam.scrumdesk.model.Task;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("taskDao")
@Transactional
public class TaskDaoImpl implements TaskDao<Task> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Task findById(long id) {
        return manager.find(Task.class, id);

    }

    @Override
    public void save(Task task) {
        manager.persist(task);
    }

    /*
    * Entity will be updated in database automatically, because class was marked as @Transactional
    * , thus every method in class will be  @Transactional.
    * */
    @Override
    public void update(Task task) {
        Task updatedTask = manager.find(Task.class, task.getId());
        updatedTask.setText(task.getText());
        updatedTask.setStatus(task.getStatus());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        Query query = manager.createQuery("select t from Task t");
        return (List<Task>)query.getResultList();
    }
}

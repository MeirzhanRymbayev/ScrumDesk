package com.epam.scrumdesk.model;

import javax.persistence.*;

/**
 * Created by Meirzhan_Rymbayev on 3/16/2016.
 */
@Entity
@Table(name = "TASK", catalog = "MEIR")
public class Task {
    private static final long serialVersionUID = 7885426911990685321L;

//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NEWS_SEQ")
//    @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "news_seq")


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_SEQ")
    @SequenceGenerator(name = "TASK_SEQ", sequenceName = "task_seq")
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Column(name = "TEXT", nullable = false)
    private String text;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (!text.equals(task.text)) return false;
        return status.equals(task.status);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + text.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

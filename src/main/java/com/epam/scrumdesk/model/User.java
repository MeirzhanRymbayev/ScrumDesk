package com.epam.scrumdesk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Meirzhan_Rymbayev on 3/25/2016.
 */
@Entity
@Table(name = "USER", catalog = "MEIR")
public class User implements Serializable {
    private static final long serialVersionUID = 7885426911990686321L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "user_seq")
    private long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;


    private Set<Task> tasks = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @OneToMany(mappedBy = "USER", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!lastname.equals(user.lastname)) return false;
        return tasks.equals(user.tasks);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + tasks.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
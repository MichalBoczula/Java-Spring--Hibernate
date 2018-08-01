package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks_list")
public class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "list_name")
    public String getListName() {
        return listName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", listName='" + listName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

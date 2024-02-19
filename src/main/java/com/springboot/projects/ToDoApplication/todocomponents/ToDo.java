package com.springboot.projects.ToDoApplication.todocomponents;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name="todo")
public class ToDo {
    public ToDo() {

    }

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 10, max = 255, message="Enter a description greater than 10 and less than 255 characters")
    private String description;
    private boolean completed;
    private LocalDate lastDate;

    public ToDo(int id, String username, String description, boolean completed, LocalDate lastDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.completed = completed;
        this.lastDate = lastDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", lastDate=" + lastDate +
                '}';
    }
}

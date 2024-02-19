package com.springboot.projects.ToDoApplication.todocomponents;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<ToDo> toDoList = new ArrayList<ToDo>();

    static{
        toDoList.add(new ToDo(1, "John", "Buy groceries", false, LocalDate.now()));
        toDoList.add(new ToDo(2, "Jane", "Buy groceries", false, LocalDate.now()));
        toDoList.add(new ToDo(3, "Mary", "Buy groceries", false, LocalDate.now()));
        toDoList.add(new ToDo(4, "John", "Buy groceries", false, LocalDate.now()));
        toDoList.add(new ToDo(5, "Jane", "Buy groceries", false, LocalDate.now()));
        toDoList.add(new ToDo(6, "Mary", "Buy groceries", false, LocalDate.now()));
    }

    public List<ToDo> getToDoList(String userName){
        return toDoList;
    }

    public void addToDo(String userName,String description, boolean status, LocalDate lastData){
        ToDo todo = new ToDo(toDoList.size()+1, userName, description, status, lastData);
        toDoList.add(todo);
    }

    public void deleteToDo(int id){
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        toDoList.removeIf(predicate);
    }

    public ToDo findToDoById(int id){
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo = toDoList.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateToDo(ToDo toDo){
        deleteToDo(toDo.getId());
        toDoList.add(toDo);
    }
}

package com.springboot.projects.ToDoApplication.todocomponents;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class ToDoController {

    //constructor injection
    public ToDoController(ToDoService toDoService, ToDoRepository toDoRepository) {
        super();
        this.toDoService = toDoService;
        this.toDoRepository = toDoRepository;
    }
    private ToDoService toDoService;
    private ToDoRepository toDoRepository;

    @RequestMapping("/todolist")
    public String toDoList(ModelMap modelMap) {
        modelMap.addAttribute("todolist", toDoRepository.findByUsername(getLoggedInUserName()));
        return "todolist";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public String addTodo(ModelMap modelMap) {
        ToDo toDo = new ToDo(0, getLoggedInUserName(), "enter the description",true,LocalDate.now());
        modelMap.addAttribute("toDo", toDo);
        return "addtodo";
    }


    @RequestMapping(value = "/addtodo", method = RequestMethod.POST)
    public String returnToDoList(ModelMap model, @Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("result is validated");
            return "addtodo";
        }
        String username = getLoggedInUserName();
        toDo.setUsername(username);
        toDoRepository.save(toDo);
        //toDoService.addToDo(username, toDo.getDescription(), true, toDo.getLastDate());
        return "redirect:todolist";
    }

    @RequestMapping(value = "/deletetodo", method = RequestMethod.GET)
    public String returnToDoList(@RequestParam int id, ModelMap model) {
        //toDoService.deleteToDo(id);

        //use h2-database to delete the items in the database.
        toDoRepository.deleteById(id);
        return "redirect:todolist";
    }

    //toupdate the existing todo.
    @RequestMapping(value = "/updatetodo", method = RequestMethod.GET)
    public String updateToDo(@RequestParam int id, ModelMap model){
        //ToDo toDo = toDoService.findToDoById(id);

        //use h2-database repository class to get values from the database.
        ToDo toDo = toDoRepository.findById(id).get();
        model.addAttribute("toDo", toDo);
        return "addtodo";
    }

    //update the exisiting todo.
    @RequestMapping(value = "/updatetodo", method = RequestMethod.POST)
    public String updateExistingToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()){
            //System.out.println("result is validated");
            return "addtodo";
        }
        String username = getLoggedInUserName();
        toDo.setUsername(username);
        //toDoService.updateToDo(toDo);

        //use h2-database repository class to update
        toDoRepository.save(toDo);
        return "redirect:todolist";
    }

    //get the userName from spring security rather than from model.
    private String getLoggedInUserName(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }
}

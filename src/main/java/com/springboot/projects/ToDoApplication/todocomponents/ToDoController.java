package com.springboot.projects.ToDoApplication.todocomponents;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ToDoController {

    //constructor injection
    public ToDoController(ToDoService toDoService) {
        super();
        this.toDoService = toDoService;
    }
    private ToDoService toDoService;

    @RequestMapping("/todolist")
    public String toDoList(ModelMap modelMap) {
        modelMap.addAttribute("todolist", toDoService.getToDoList("testUser"));
        return "todolist";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public String addTodo(ModelMap modelMap) {
        ToDo toDo = new ToDo(0, (String)modelMap.get("name"), "enter the description",true,LocalDate.now());
        modelMap.addAttribute("toDo", toDo);
        return "addtodo";
    }


    @RequestMapping(value = "/addtodo", method = RequestMethod.POST)
    public String returnToDoList(ModelMap model, @Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("result is validated");
            return "addtodo";
        }
        String username = (String)model.get("name");
        toDoService.addToDo(username, toDo.getDescription(), true, toDo.getLastDate());
        return "redirect:todolist";
    }

    @RequestMapping(value = "/deletetodo", method = RequestMethod.GET)
    public String returnToDoList(@RequestParam int id, ModelMap model) {
        toDoService.deleteToDo(id);
        return "redirect:todolist";
    }

    //toupdate the existing todo.
    @RequestMapping(value = "/updatetodo", method = RequestMethod.GET)
    public String updateToDo(@RequestParam int id, ModelMap model){
        ToDo toDo = toDoService.findToDoById(id);
        model.addAttribute("toDo", toDo);
        return "addtodo";
    }

    //update the exisiting todo.
    @RequestMapping(value = "/updatetodo", method = RequestMethod.POST)
    public String updateExistingToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("result is validated");
            return "addtodo";
        }
        String username = (String)model.get("name");
        toDo.setUsername(username);
        toDoService.updateToDo(toDo);
        return "redirect:todolist";
    }
}

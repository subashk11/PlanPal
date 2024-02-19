package com.springboot.projects.ToDoApplication.loginComponents;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("name", "testUser");
        return "welcome";
    }
}

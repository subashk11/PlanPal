package com.springboot.projects.ToDoApplication.loginComponents;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping("/")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }
}

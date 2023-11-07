package com.Barberia.Barber.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
public class UserController {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("index");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("index");
    }
}


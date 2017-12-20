package com.java.controller;

import com.java.model.User;
import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "cat")
    public ModelAndView cat() {
        ModelAndView modelAndView = new ModelAndView("/user/cat");
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("listUser", userService.listUser());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("user/form");
        modelAndView.addObject("userForm", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("user/form");
        modelAndView.addObject("userForm", userService.findUserById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("userForm") User user) {
        System.out.print(user.getId());
        // Fix
        if (user.getId() != null && !user.getId().trim().equals("")) {
            // update
            userService.update(user);
            System.out.println("update");
        } else {
            userService.add(user);
            System.out.println("ELXE");
        }

        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        User user = userService.findUserById(id);
        userService.delete(user);

        return "redirect:/user/list";
    }
}

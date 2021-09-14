package com.jantoleu.rooms_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {

    @GetMapping({"/","index.html"})
    public String index(@RequestParam(name="userName", required=false, defaultValue="World") String userNameParam, Model model) {
        model.addAttribute("nameAttribute", userNameParam);
        return "index";
    }

}

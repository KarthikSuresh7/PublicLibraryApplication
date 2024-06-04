package com.library.publicLibrary.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @GetMapping("/library")
    public String libraryHome(Model model) {
        model.addAttribute("message", "Welcome to the Library!");
        return "library";
    }
}

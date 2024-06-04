package com.library.publicLibrary.controller;

import com.library.publicLibrary.form.UserInput;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody UserInput users){
        return ResponseEntity.ok(userService.register(users));
    }

    @GetMapping
    public ResponseEntity<List<User>>registeredUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long userId){
        return ResponseEntity.ok(userService.findByUsersId(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteById(@PathVariable Integer userId){

                userService.deleteUserId(userId);
        return "Successfully deleted";
    }
}

package com.library.publicLibrary.service;

import com.library.publicLibrary.form.UserInput;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;
    @Override
    public User register(UserInput users) {
        User userModel = new User();
        userModel.setPassword(users.getPassword());
        userModel.setRole(users.getRole());
        userModel.setUsername(users.getUsername());
        userModel.setEmail(users.getEmail());
        return userRepo.save(userModel);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findByUsersId(Long userId) {
        return userRepo.findById(userId);
    }

    @Override
    public String deleteUserId(Integer userId) {

        userRepo.deleteById(Long.valueOf(userId));
        return "Success";
    }


}

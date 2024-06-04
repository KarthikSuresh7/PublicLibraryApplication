package com.library.publicLibrary.service;

import com.library.publicLibrary.form.UserInput;
import com.library.publicLibrary.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User register(UserInput users);

   List<User> findAllUser();

    Optional<User> findByUsersId(Long userId);


    String deleteUserId(Integer userId);
}

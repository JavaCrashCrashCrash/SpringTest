package com.doma.test.service;

import com.doma.test.entity.User;
import com.doma.test.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public boolean signUp(String id, String pwd, String name) {
        if (!userRepository.existsById(id)) {
            System.out.println("======Service======");
            System.out.println("id : " + id + " , pwd : " + pwd);
            User user = User.builder().id(id).pwd(pwd).name(name).build();
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User getUserById(String id) {
        return userRepository.getById(id);
    }
}

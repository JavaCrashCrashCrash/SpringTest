package com.doma.test.service;

import com.doma.test.entity.User;
import com.doma.test.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String signUp(String id, String pwd, String name) {
        if (!userRepository.existsById(id)) {
            System.out.println("======Service======");
            System.out.println("id : " + id + " , pwd : " + pwd);
            User user = User.builder().id(id).pwd(pwd).name(name).build();
            userRepository.save(user);
            return "sign up successful";
        } else {
            return "sign up failed";
        }
    }

    @Transactional
    public String modify(String id, String newPwd, String newName) {
        User user = userRepository.getUserById(id);
            userRepository.modify(id, newPwd, newName);
            return "Change applied";
    }

    public String login(String id, String pwd) {
        User user = getUserById(id);
        if (user.getPwd().equals(pwd)) {
            return "Welcome";
        } else {
            return "Access Denied";
        }
    }

    public void delete(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Transactional
    public String deleteUserById(String id) {
        if (userRepository.deleteUserById(id) == 1) {
            return "삭제 되었습니다.";
        } else {
            return "Failed to delete";
        }
    }
}

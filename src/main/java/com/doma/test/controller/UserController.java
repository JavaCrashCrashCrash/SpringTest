package com.doma.test.controller;

import com.doma.test.entity.User;
import com.doma.test.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    List<User> userList;


    @GetMapping("/hello")
    public String hello() {
        String result = "Hello Spring Framework!!";
        return result;
    }

    // TODO 아이디 중복 확인
    @GetMapping("/signup")
    public String signUp(@RequestParam("id") String id, @RequestParam("password") String pwd, @RequestParam("name") String name) {
        if (userService.signUp(id, pwd, name)) {
            return "Sign Up Successed.";
        } else {
            return "ID already exists.";
        }
    }

    // TODO 로그인 ID, PASSWORD 확인
    @GetMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String pwd) {
        return "you are in!";
    }

    // TODO 회원수정
    @GetMapping("/modify")
    public String modify(@RequestParam("id") String id, @RequestParam("password") String pwd, @RequestParam("newId") String newId, @RequestParam("newPassword") String newPw) {
        User user = userService.getUserById(id);
        userService.getUserRepository().delete(user);
        user.setId(newId);
        user.setId(newPw);
        userService.getUserRepository().save(user);
        return "id/pwd changed!";
    }

    // TODO 회원탈퇴
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        User user = userService.getUserById(id);
        userService.getUserRepository().delete(user);
        return "deleted";
    }


    @GetMapping("/v1/user/all")
    public List<User> getUsers() {
        userList = userService.getUsers();
        return userList;
    }
}

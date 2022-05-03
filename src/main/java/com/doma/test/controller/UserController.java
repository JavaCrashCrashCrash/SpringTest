package com.doma.test.controller;

import com.doma.test.entity.User;
import com.doma.test.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/v1/user/signup")
    public String signUp(@RequestParam("id") String id, @RequestParam("password") String pwd, @RequestParam("name") String name) {
        if (userService.signUp(id, pwd, name)) {
            return "Sign Up Successed.";
        } else {
            return "ID already exists.";
        }
    }

    // TODO 로그인 ID, PASSWORD 확인
    @GetMapping("/v1/user/login")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
        return userService.login(id, pwd);
    }

    // TODO 회원수정
    @PostMapping("/v1/user/modify")
    public String modify(@RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("newId") String newId, @RequestParam("newPwd") String newPwd, @RequestParam("newName") String newName) {
        return userService.modify(id, pwd, newId, newPwd, newName);
    }

    // TODO 회원탈퇴
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        userService.delete(id);
        return "deleted";
    }

    @GetMapping("/v1/user/all")
    public List<User> getUsers() {
        userList = userService.getUsers();
        return userList;
    }

    @GetMapping("/v1/user/")
    public User getUserById(@RequestParam("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/v1/delete/user")
    public String deleteUserById(@RequestParam("id") String id) {
        return userService.deleteUserById(id);
    }
}

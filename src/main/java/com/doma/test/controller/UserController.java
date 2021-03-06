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

    @PostMapping("/v1/user/signup")
    @CrossOrigin("*")
    public String signUp(@RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("name") String name) {
        return userService.signUp(id, pwd, name);
    }

    @GetMapping("/v1/user/login")
    @CrossOrigin("*")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);
        return userService.login(id, pwd);
    }

    @PostMapping("/v1/user/modify")
    @CrossOrigin("*")
    public String modify(@RequestParam("id") String id, @RequestParam("newPwd") String newPwd, @RequestParam("newName") String newName) {
        return userService.modify(id, newPwd, newName);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        userService.delete(id);
        return "deleted";
    }

    @GetMapping("/v1/user/all")
    @CrossOrigin("*")
    public List<User> getUsers() {
        userList = userService.getUsers();
        return userList;
    }

    @GetMapping("/v1/user/")
    public User getUserById(@RequestParam("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/v1/user/delete")
    @CrossOrigin("*")
    public String deleteUserById(@RequestParam("id") String id) {
        System.out.println("delete User By Id!!! : " + id);
        return userService.deleteUserById(id);
    }
}

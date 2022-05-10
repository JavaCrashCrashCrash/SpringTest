package com.doma.test.controller;

import com.doma.test.entity.Ranker;
import com.doma.test.service.RankerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankerController {
    private final RankerService rankerService;
    List<Ranker> rankerList;

    // operation checking
    @GetMapping("/check")
    public String check() {
        return "Checking in";
    }

    @PostMapping("/ranker/insert")
    public String insert(@RequestParam("id") String id, @RequestParam("record") String record) {
        if (rankerService.insert(id, record)) {
            return id + " registered";
        } else {
            return "ID already exists";
        }
    }

    @PostMapping("/ranker/modify")
    public String modify(@RequestParam("id") String id, @RequestParam("newId") String newId, @RequestParam("newRecord") String newRecord) {
        if (rankerService.modify(id, newId, newRecord)) {
            return "Successfully changed";
        } else {
            return "Wrong approach";
        }
    }

    @PostMapping("/ranker/delete")
    public String deleteRankerById(@RequestParam("id") String id) {
        if (rankerService.deleteRankerById(id)) {
            return "Deleted";
        } else {
            return "Wrong approach";
        }
    }

    @GetMapping("/ranker/all")
    public List<Ranker> getRankerList() {
        System.out.println("Get Ranker!!!!");
        return rankerService.getRankers();
    }

    @GetMapping("/ranker/")
    public Ranker getRankerById(@RequestParam("id") String id) {
        return rankerService.getRankerById(id);
    }

    @GetMapping("/ranker/sort")
    public List<Ranker> sortRankers() {
        return rankerService.sortRankers();
    }
}

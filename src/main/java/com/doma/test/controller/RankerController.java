package com.doma.test.controller;

import com.doma.test.entity.Ranker;
import com.doma.test.service.RankerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin("*")
    public String insert(@RequestParam("userId") String userId, @RequestParam("record") String record) {
        if (rankerService.insert(userId, record)) {
            return userId + " registered";
        } else {
            return "ID already exists";
        }
    }

    @PostMapping("/ranker/modify")
    @CrossOrigin("*")
    // TODO
    public String modify(@RequestParam("rankerId") int rankerId, @RequestParam("newRecord") String newRecord) {
        if (rankerService.modify(rankerId, newRecord)) {
            return "Successfully changed";
        } else {
            return "Wrong approach";
        }
    }

    @PostMapping("/ranker/delete")
    @CrossOrigin("*")
    // TODO
    public String deleteRankerById(@RequestParam("rankerId") int rankerId) {
        if (rankerService.deleteRanker(rankerId)) {
            return "Deleted";
        } else {
            return "Wrong approach";
        }
    }

    @GetMapping("/ranker/all")
    @CrossOrigin("*")
    public List<Ranker> getRankerList() {
        return rankerService.getRankers();
    }

    @GetMapping("/ranker/")
    public Ranker getRankerById(@RequestParam("rankerId") int rankerId) {
        return rankerService.getRankerById(rankerId);
    }

    @GetMapping("/ranker/sort")
    @CrossOrigin("*")
    public List<Ranker> sortRankers() {
        return rankerService.sortRankers();
    }
}

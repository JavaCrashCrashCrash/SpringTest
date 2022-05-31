package com.doma.test.service;

import com.doma.test.entity.Ranker;
import com.doma.test.repository.RankerRepository;
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
public class RankerService {
    private final RankerRepository rankerRepository;

    public boolean insert(String userId, String record) {
        Ranker ranker = Ranker.builder()
                .userId(userId)
                .record(record)
                .build();
        rankerRepository.save(ranker);
        return true;
    }

    @Transactional
    public boolean modify(int rankerId, String newRecord) {
        if (rankerRepository.modify(rankerId, newRecord) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deleteRanker(int rankerId) {
        if (rankerRepository.deleteRankerById(rankerId) == 1) {
            return true;
        } else {
            return false;
        }

    }

    public List<Ranker> getRankers() {

//        return rankerRepository.getRankers();
        return null;
    }

    public List<Ranker> sortRankers() {
        return rankerRepository.sortRankers();
    }

    public Ranker getRankerById(int rankerId) {
        return rankerRepository.getRankerById(rankerId);
    }

}

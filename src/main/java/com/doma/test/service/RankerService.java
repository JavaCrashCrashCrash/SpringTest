package com.doma.test.service;

import com.doma.test.entity.Ranker;
import com.doma.test.repository.RankerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class RankerService {
    private final RankerRepository rankerRepository;

    public boolean insert(String id, String record) {
        if (!rankerRepository.existsById(id)) {
            Ranker ranker = Ranker.builder().id(id).record(record).build();
            rankerRepository.save(ranker);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean modify(String id,  String newRecord) {
        if (!rankerRepository.existsById(id)) {
            rankerRepository.modify(id, newRecord);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deleteRankerById(String id) {
        if (rankerRepository.existsById(id)) {
            rankerRepository.delete(getRankerById(id));
            return true;
        } else {
            return false;
        }
    }

    public List<Ranker> getRankers() {
        return rankerRepository.getRankers();
    }

    public List<Ranker> sortRankers() {
        return rankerRepository.sortRankers();
    }

    public Ranker getRankerById(String id) {
        return rankerRepository.getRankerById(id);
    }

}

package com.doma.test.repository;

import com.doma.test.entity.Ranker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankerRepository extends JpaRepository<Ranker, String> {

    @Query("SELECT r FROM Ranker r WHERE r.rankerId=:rankerId")
    Ranker getRankerById(@Param("rankerId") int rankerId);

    @Modifying
    @Query("DELETE FROM Ranker r WHERE r.rankerId=:rankerId")
    int deleteRankerById(@Param("rankerId") int rankerId);

    @Modifying
    @Query("UPDATE Ranker r SET r.record=:newRecord Where r.rankerId=:rankerId")
    int modify(@Param("rankerId") int rankerId, @Param("newRecord") String newRecord);

    @Query("SELECT r from Ranker r order by r.record asc")
    List<Ranker> sortRankers();

//    @Query("SELECT r from Ranker r")
//    List<Ranker> getRankers();

}
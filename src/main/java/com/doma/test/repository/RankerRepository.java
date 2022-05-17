package com.doma.test.repository;

import com.doma.test.entity.Ranker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankerRepository extends JpaRepository<Ranker, String> {

    @Query("SELECT r FROM Ranker r WHERE r.id=:id")
    Ranker getRankerById(@Param("id") String id);

    @Modifying
    @Query("DELETE FROM Ranker r WHERE r.id=:id")
    int deleteRankerById(@Param("id") String id);

    @Modifying
    @Query("UPDATE Ranker r SET r.record=:newRecord Where r.id=:id")
    int modify(@Param("id") String id, @Param("newRecord") String newRecord);

    @Query("SELECT r from Ranker r order by r.record asc")
    List<Ranker> sortRankers();

    @Query("SELECT r from Ranker r")
    List<Ranker> getRankers();

}
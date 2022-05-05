package com.doma.test.repository;

import com.doma.test.entity.Ranker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RankerRepository extends JpaRepository<Ranker, String> {

    @Query("SELECT r FROM Ranker r WHERE r.id=:id")
    Ranker getRankerById(@Param("id") String id);

    @Query("DELETE FROM Ranker r WHERE r.id=:id")
    int deleteRankerById(@Param("id") String id);

    @Modifying
    @Query("UPDATE Ranker r SET r.id=:newId, r.record=:newRecord")
    int modify(@Param("id") String id, @Param("newId") String newId, @Param("newRecord") String newRecord);
}
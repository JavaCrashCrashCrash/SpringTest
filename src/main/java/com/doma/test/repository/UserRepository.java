package com.doma.test.repository;

import com.doma.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
//     select * from user where id = ?
    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getUserById(@Param("id") String id);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteUserById(@Param("id") String id);

    @Modifying
    @Query("UPDATE User u SET u.id=:newId, u.pwd=:newPwd, u.name=:newName Where u.id=:id")
    int modify(@Param("id") String id, @Param("newId") String newId, @Param("newPwd") String newPwd, @Param("newName") String newName);

}

// src/main/java/com/legosetmatcher/repository/UserLegoSetRepository.java
package com.legosetmatcher.repository;

import com.legosetmatcher.model.User;
import com.legosetmatcher.model.UserLegoSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLegoSetRepository extends JpaRepository<UserLegoSet, Long> {
    List<UserLegoSet> findByUser(User user);
    boolean existsByUserAndLegoSetSetNumber(User user, String setNumber);

    @Query("SELECT uls.legoSet.setNumber FROM UserLegoSet uls WHERE uls.user = :user")
    List<String> findSetNumbersByUser(@Param("user") User user);
}
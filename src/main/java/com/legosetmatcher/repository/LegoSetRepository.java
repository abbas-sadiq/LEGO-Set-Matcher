// src/main/java/com/legosetmatcher/repository/LegoSetRepository.java
package com.legosetmatcher.repository;

import com.legosetmatcher.model.LegoSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegoSetRepository extends JpaRepository<LegoSet, String> {
    boolean existsBySetNumber(String setNumber);
}
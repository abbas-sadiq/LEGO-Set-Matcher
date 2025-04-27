// src/main/java/com/legosetmatcher/service/LegoSetService.java
package com.legosetmatcher.service;

import com.legosetmatcher.model.LegoSet;
import java.util.List;

public interface LegoSetService {
    LegoSet getSetByNumber(String setNumber);
    List<LegoSet> getAllSets();
    void saveSet(LegoSet legoSet);
}
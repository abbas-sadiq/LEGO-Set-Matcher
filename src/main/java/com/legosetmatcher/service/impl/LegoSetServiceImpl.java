// src/main/java/com/legosetmatcher/service/impl/LegoSetServiceImpl.java
package com.legosetmatcher.service.impl;

import com.legosetmatcher.model.LegoSet;
import com.legosetmatcher.repository.LegoSetRepository;
import com.legosetmatcher.service.LegoSetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LegoSetServiceImpl implements LegoSetService {
    private final LegoSetRepository legoSetRepository;

    public LegoSetServiceImpl(LegoSetRepository legoSetRepository) {
        this.legoSetRepository = legoSetRepository;
    }

    @Override
    public LegoSet getSetByNumber(String setNumber) {
        return legoSetRepository.findById(setNumber).orElseThrow();
    }

    @Override
    public List<LegoSet> getAllSets() {
        return legoSetRepository.findAll();
    }

    @Override
    public void saveSet(LegoSet legoSet) {
        legoSetRepository.save(legoSet);
    }
}
// src/main/java/com/legosetmatcher/service/impl/UserLegoSetServiceImpl.java
package com.legosetmatcher.service.impl;

import com.legosetmatcher.model.LegoSet;
import com.legosetmatcher.model.User;
import com.legosetmatcher.model.UserLegoSet;
import com.legosetmatcher.repository.LegoSetRepository;
import com.legosetmatcher.repository.UserLegoSetRepository;
import com.legosetmatcher.service.UserLegoSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLegoSetServiceImpl implements UserLegoSetService {

    private final UserLegoSetRepository userLegoSetRepository;
    private final LegoSetRepository legoSetRepository;

    @Override
    public UserLegoSet addSetToUser(User user, String setNumber) {
        // Check if set exists in our database
        LegoSet legoSet = legoSetRepository.findById(setNumber)
                .orElseThrow(() -> new RuntimeException("Lego set not found"));

        // Create new relationship
        UserLegoSet userLegoSet = new UserLegoSet();
        userLegoSet.setUser(user);
        userLegoSet.setLegoSet(legoSet);
        userLegoSet.setAddedDate(LocalDate.now());

        return userLegoSetRepository.save(userLegoSet);
    }

    @Override
    public List<UserLegoSet> getUserSets(User user) {
        return userLegoSetRepository.findByUser(user);
    }

    @Override
    public boolean userOwnsSet(User user, String setNumber) {
        return userLegoSetRepository.existsByUserAndLegoSetSetNumber(user, setNumber);
    }
}
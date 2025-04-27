// src/main/java/com/legosetmatcher/service/UserLegoSetService.java
package com.legosetmatcher.service;

import com.legosetmatcher.model.User;
import com.legosetmatcher.model.UserLegoSet;

import java.util.List;

public interface UserLegoSetService {
    UserLegoSet addSetToUser(User user, String setNumber);
    List<UserLegoSet> getUserSets(User user);
    boolean userOwnsSet(User user, String setNumber);
}
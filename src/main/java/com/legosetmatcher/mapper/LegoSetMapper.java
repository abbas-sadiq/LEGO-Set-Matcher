// src/main/java/com/legosetmatcher/mapper/LegoSetMapper.java
package com.legosetmatcher.mapper;

import com.legosetmatcher.dto.response.LegoSetResponse;
import com.legosetmatcher.model.LegoSet;
import org.springframework.stereotype.Component;

@Component
public class LegoSetMapper {
    public LegoSetResponse toResponse(LegoSet legoSet) {
        if (legoSet == null) {
            return null;
        }
        return new LegoSetResponse(
                legoSet.getSetNumber(),
                legoSet.getName(),
                legoSet.getImageUrl(),
                legoSet.getPieceCount()
        );
    }
}
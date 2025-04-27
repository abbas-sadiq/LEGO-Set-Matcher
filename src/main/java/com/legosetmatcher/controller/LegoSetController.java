package com.legosetmatcher.controller;

import com.legosetmatcher.dto.response.LegoSetResponse;
import com.legosetmatcher.exception.ApiResponse;
import com.legosetmatcher.mapper.LegoSetMapper;
import com.legosetmatcher.model.LegoSet;
import com.legosetmatcher.service.LegoSetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sets")
public class LegoSetController {

    private final LegoSetService legoSetService;
    private final LegoSetMapper legoSetMapper;

    public LegoSetController(LegoSetService legoSetService, LegoSetMapper legoSetMapper) {
        this.legoSetService = legoSetService;
        this.legoSetMapper = legoSetMapper;
    }



    @GetMapping("/{setNumber}")
    public ResponseEntity<ApiResponse<LegoSetResponse>> getSet(@PathVariable String setNumber) {
        LegoSet legoSet = legoSetService.getSetByNumber(setNumber);
        return ResponseEntity.ok(new ApiResponse<>(true,legoSetMapper.toResponse(legoSet),null));
    }
}
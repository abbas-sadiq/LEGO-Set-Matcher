package com.legosetmatcher.service;

import com.legosetmatcher.dto.LegoSetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.legosetmatcher.model.LegoSet;

@Service
@RequiredArgsConstructor
public class RebrickableService {

    private final RestTemplate restTemplate;

    @Value("${rebrickable.api.key}")
    private String apiKey;

    @Value("${rebrickable.api.base-url}")
    private String baseUrl;
    public LegoSetDto getSetDetails(String setNumber) {
        String url = baseUrl + "/sets/" + setNumber + "/?key=" + apiKey;
        LegoSetDto legoSet = restTemplate.getForObject(url, LegoSetDto.class);
        return legoSet;
    }
}

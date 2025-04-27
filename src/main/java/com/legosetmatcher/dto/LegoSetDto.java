package com.legosetmatcher.dto;

import lombok.Data;

@Data
public class LegoSetDto {
    private String setNumber;  // Using Rebrickable set number as ID
    private String name;
    private String imageUrl;
    private int pieceCount;
}

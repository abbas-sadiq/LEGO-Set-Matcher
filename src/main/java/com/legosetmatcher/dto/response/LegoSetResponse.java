package com.legosetmatcher.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Data
public class LegoSetResponse {
    private String setNumber;
    private String name;
    private String imageUrl;
    private int pieceCount;
}
package com.legosetmatcher.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class AddSetRequest {
    private String setNumber; // LEGO set ka unique code
}
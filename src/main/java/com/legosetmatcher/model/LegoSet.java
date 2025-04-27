
package com.legosetmatcher.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class LegoSet {
    @Id
    private String setNumber;  // Using Rebrickable set number as ID

    private String name;
    private String imageUrl;
    private int pieceCount;
}
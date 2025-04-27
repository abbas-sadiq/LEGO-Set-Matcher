// src/main/java/com/legosetmatcher/model/UserLegoSet.java
package com.legosetmatcher.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class UserLegoSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private LegoSet legoSet;

    private LocalDate addedDate = LocalDate.now();
}
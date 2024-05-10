package com.edwinsoto.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Adopter {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean isOver18;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
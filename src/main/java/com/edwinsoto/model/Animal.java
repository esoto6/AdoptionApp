package com.edwinsoto.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class Animal {
    protected int id;
    protected String name;
    protected String type;
    protected LocalDate dob;
    protected String breed;
    protected LocalDate adoptedDate;
    protected Adopter owner;
}


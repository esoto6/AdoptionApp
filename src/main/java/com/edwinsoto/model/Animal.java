package com.edwinsoto.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "adopter")
@Entity
@Data
@Builder
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;
    @Column(name = "name")
    protected String name;
    @Column(name = "type")
    protected String type;
    @Column(name = "dob")
    protected LocalDate dob;
    @Column(name = "breed")
    protected String breed;
    @Column(name = "adoptedDate")
    protected LocalDate adoptedDate;
//    @JoinColumn(name = "adopter")
//    @ManyToOne(fetch = FetchType.LAZY)
//    protected Adopter owner;
}


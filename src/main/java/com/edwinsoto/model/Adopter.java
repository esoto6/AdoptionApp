package com.edwinsoto.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "adopter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "is18")
    private boolean isOver18;
    @Column(name = "dateCreated")
    private LocalDate dateCreated;
    @Column(name = "dateModified")
    private LocalDate dateModified;
}
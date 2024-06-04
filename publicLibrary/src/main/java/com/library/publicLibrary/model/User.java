package com.library.publicLibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
    private String email;
}

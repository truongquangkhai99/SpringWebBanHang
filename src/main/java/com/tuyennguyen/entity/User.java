package com.tuyennguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String fullName;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String role;

}

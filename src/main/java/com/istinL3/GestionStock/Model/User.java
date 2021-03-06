package com.istinL3.GestionStock.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public User(String username, String firstname, String email, String password) {

        this.username = username;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }


}

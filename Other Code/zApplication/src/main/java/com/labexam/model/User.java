package com.labexam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
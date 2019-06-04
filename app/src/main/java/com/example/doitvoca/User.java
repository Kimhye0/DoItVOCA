package com.example.doitvoca;

public class User {
    public String ID,PW,Nickname;

    public User(){

    }

    public User(String email, String password, String name){
        this.ID = email;
        this.PW = password;
        this.Nickname = name;
    }

}

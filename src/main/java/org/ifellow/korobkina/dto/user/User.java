package org.ifellow.korobkina.dto.user;

import lombok.Data;

@Data
public class User {
    public String name;
    public String job;
    public int id;
    public String createdAt;

    /*public User(String name, String job){
        this.name = name;
        this.job = job;
    }*/
}

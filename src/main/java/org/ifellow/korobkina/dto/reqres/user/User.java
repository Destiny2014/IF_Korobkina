package org.ifellow.korobkina.dto.reqres.user;

import lombok.Data;

@Data
public class User {
    public String name;
    public String job;
    public int id;
    public String createdAt;
}
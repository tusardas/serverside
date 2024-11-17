package com.hellonext.serverside.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    public Long id;
    public String email;
    public Long roleId;
    public String password;
    public String firstName;
    public String lastName;

}

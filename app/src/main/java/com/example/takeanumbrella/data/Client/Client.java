package com.example.takeanumbrella.data.Client;

import androidx.annotation.NonNull;

public class Client {

    final private Long id;
    final private String name;
    final private String telephone;
    final private String email;
    final private String passwordHash;

    public Client(Long id, String name, String telephone, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Client() {
        id = null;
        name = null;
        passwordHash = null;
        email = null;
        telephone = null;
    }

    public Client(String name, String telephone, String email, String passwordHash) {
        this.id = null;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    @NonNull
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}

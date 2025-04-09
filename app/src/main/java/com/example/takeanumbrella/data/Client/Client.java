package com.example.takeanumbrella.data.Client;

import androidx.annotation.NonNull;

public class Client {

    private Long id;
    final private String name;
    final private String phone;
    final private String email;
    final private String passwordHash;

    public Client(Long id, String name, String phone, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Client() {
        id = null;
        name = null;
        passwordHash = null;
        email = null;
        phone = null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client(String name, String phone, String email, String passwordHash) {
        this.id = null;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}

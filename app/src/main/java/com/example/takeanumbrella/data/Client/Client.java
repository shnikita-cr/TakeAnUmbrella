package com.example.takeanumbrella.data.Client;

public class Client {

    final private Long id;
    final private String name;
    final private String email;
    final private String passwordHash;

    public Client(Long id, String name, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Client() {
        id = null;
        name = null;
        passwordHash = null;
        email = null;
    }

    public Client(String username, String password) {
        email = username;
        passwordHash = password;

        name = null;
        id = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}

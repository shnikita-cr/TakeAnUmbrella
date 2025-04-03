package com.example.takeanumbrella.data.model;

import com.example.takeanumbrella.data.Client.Client;
import com.example.takeanumbrella.data.Client.ClientController;
import com.example.takeanumbrella.data.Client.ClientTestResponse;
import com.example.takeanumbrella.ui.register.RegisteredUser;

import java.io.IOException;

public class RegisterDataSource {

    public Result<RegisteredUser> register(
            String name,
            String phone,
            String email,
            String password) {
        try {
            // TODO: handle loggedInUser authentication
            Client client = new Client(name, phone,email,password);
            ClientTestResponse response = ClientController.testClient(client);
            if (response.getResult()) {
                Client freshCLient = response.getClient();
                return new Result.Success<>(freshCLient);
            } else {
                return new Result.Error(new RuntimeException("Client not found"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }
}

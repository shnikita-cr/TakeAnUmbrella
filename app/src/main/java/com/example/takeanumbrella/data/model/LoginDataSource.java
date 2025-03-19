package com.example.takeanumbrella.data.model;

import com.example.takeanumbrella.data.Client.Client;
import com.example.takeanumbrella.data.Client.ClientController;
import com.example.takeanumbrella.data.Client.ClientTestResponse;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {
            // TODO: handle loggedInUser authentication
            Client client = new Client(username, password);
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

    public void logout() {
        // TODO: revoke authentication
    }
}
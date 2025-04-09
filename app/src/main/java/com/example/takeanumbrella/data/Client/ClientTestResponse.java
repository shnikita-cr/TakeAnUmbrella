package com.example.takeanumbrella.data.Client;

import com.example.takeanumbrella.ui.register.RegisteredClient;

public class ClientTestResponse {
    Boolean result;
    RegisteredClient client;

    public ClientTestResponse(Boolean result, RegisteredClient client) {
        this.result = result;
        this.client = client;
    }

    public ClientTestResponse() {
        result = false;
        client = null;
    }

    public Boolean getResult() {
        return result;
    }

    public RegisteredClient getRegisteredClient() {
        return client;
    }
}

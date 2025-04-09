package com.example.takeanumbrella.data.Client;

public class ClientTestResponse {
    Boolean result;
    Client client;

    public ClientTestResponse(Boolean result, Client client) {
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

    public Client getRegisteredClient() {
        return client;
    }
}

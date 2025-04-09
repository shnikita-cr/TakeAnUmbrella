package com.example.takeanumbrella.data.model;

import com.example.takeanumbrella.data.Client.Client;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class RegisterRepository {

    private static volatile RegisterRepository instance;
    private final RegisterDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private Client user = null;

    // private constructor : singleton access
    private RegisterRepository(RegisterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RegisterRepository getInstance(RegisterDataSource dataSource) {
        if (instance == null) {
            instance = new RegisterRepository(dataSource);
        }
        return instance;
    }

    private void setRegisteredInClient(Client client) {
        this.user = client;
        // If client credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<Client> register(
            String name,
            String phone,
            String email,
            String password) {
        Result<Client> result = dataSource.register(
                name,
                phone,
                email,
                password
        );
        if (result instanceof Result.Success) {
            setRegisteredInClient(((Result.Success<Client>) result).getData());
        }
        return result;
    }
}
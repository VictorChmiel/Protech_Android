package com.example.sportapp.DTO;


/**
 * Credentials sent by a user to authenticate
 * @author JB Nizet
 */
public final class CredentialsDTO {

    private final String login;

    /**
     * The password, in clear text.
     */

    private final String password;


    public CredentialsDTO( String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

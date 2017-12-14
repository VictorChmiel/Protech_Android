package com.example.sportapp.util;

/**
 * A user, with its JWT token
 * @author JB Nizet
 */
public class AuthenticatedUser {
    private static boolean authentified;
    private static Long id;
    private static String login;
    private static boolean admin;
    private static String token;

    public AuthenticatedUser(Long id, String login, boolean admin, String token, boolean authentified) {
        this.id = id;
        this.login = login;
        this.admin = admin;
        this.token = token;
        this.authentified = authentified;
    }

    public static Long getId() {
        return id;
    }

    public static String getLogin() {
        return login;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static String getToken() {
        return token;
    }

    public static void setAdmin(boolean admin) {
        AuthenticatedUser.admin = admin;
    }

    public static void setId(Long id) {
        AuthenticatedUser.id = id;
    }

    public static void setLogin(String login) {
        AuthenticatedUser.login = login;
    }

    public static void setToken(String token) {
        AuthenticatedUser.token = token;
    }

    public static boolean isAuthentified() {
        return authentified;
    }

    public static void setAuthentified(boolean authentified) {
        AuthenticatedUser.authentified = authentified;
    }
}

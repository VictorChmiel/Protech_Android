package com.example.sportapp.DTO;

import com.example.sportapp.util.Sexe;

import java.util.Date;

/**
 * Created by corentin on 13/12/17.
 */

public final class UserCommandCaracteristiqueDTO {

    private final String login;
    private final boolean admin;
    private final String password;
    private final String sexe;
    private final String date_naissance;
    private final CaracteristiqueCommandDTO caracteristique;


    public UserCommandCaracteristiqueDTO( String login,
                                          boolean admin,
                                          String sexe,
                                          String password,
                                          String date_naissance,
                                          CaracteristiqueCommandDTO caracteristique
                                        ){
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.caracteristique = caracteristique;
    }


    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPassword() {
        return password;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public CaracteristiqueCommandDTO getCaracteristique() {
        return caracteristique;
    }
}

package com.example.sportapp.DTO;

/**
 * Created by corentin on 13/12/17.
 */

public class CaracteristiqueCommandDTO {

    private final int taille;

    private final int poids;


    public CaracteristiqueCommandDTO (int taille,
                                      int poids
                                      ){

        this.poids = poids;
        this.taille = taille;
    }


    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }
}

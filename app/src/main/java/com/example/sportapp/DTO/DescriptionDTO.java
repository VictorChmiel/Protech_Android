package com.example.sportapp.DTO;

public final class DescriptionDTO {
    private final Long id;

    private final String texte;

    private final String image;

    private final int tempo;

    public DescriptionDTO(Long id, String texte, String image, int tempo) {
        this.id = id;
        this.texte = texte;
        this.image = image;
        this.tempo = tempo;
    }

    public Long getId() {
        return id;
    }

    public int getTempo() {
        return tempo;
    }

    public String getImage() {
        return image;
    }

    public String getTexte() {
        return texte;
    }
}

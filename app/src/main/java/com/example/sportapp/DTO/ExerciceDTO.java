package com.example.sportapp.DTO;

import java.util.List;

public final class ExerciceDTO {
    private final Long id;

    private final String nom;

    private final MusclesDTO muscles;

    private final MaterielsDTO materiels;

    private final List<DescriptionDTO> description;

    private final int difficulte;

    private final boolean repetition;

    private final boolean poids;


    public Long getId() {
        return id;
    }

    public ExerciceDTO(Long id, String nom, MusclesDTO muscles, MaterielsDTO materiels, List<DescriptionDTO> description, int difficulte, boolean repetition, boolean poids) {
        this.id = id;
        this.nom = nom;
        this.muscles = muscles;
        this.materiels = materiels;
        this.description = description;
        this.difficulte = difficulte;
        this.repetition = repetition;
        this.poids = poids;
    }

    public List<DescriptionDTO> getDescription() {
        return description;
    }

    public boolean isPoids() {
        return poids;
    }

    public boolean isRepetition() {
        return repetition;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getNom() {
        return nom;
    }

    public MaterielsDTO getMateriels() {
        return materiels;
    }

    public MusclesDTO getMuscles() {
        return muscles;
    }
}

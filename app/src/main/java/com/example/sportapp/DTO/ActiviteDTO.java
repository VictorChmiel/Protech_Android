package com.example.sportapp.DTO;

public final class ActiviteDTO {
    private final Long id;

    private final int repetition;

    private final int temporisation;

    private final int poids;

    private final int note;

    private final ExerciceDTO exercice;


    public ActiviteDTO(Long id, int repetition, int temporisation, int poids, int note, ExerciceDTO exercice) {
        this.id = id;
        this.repetition = repetition;
        this.temporisation = temporisation;
        this.poids = poids;
        this.note = note;
        this.exercice = exercice;
    }

    public Long getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public int getPoids() {
        return poids;
    }

    public ExerciceDTO getExercice() {
        return exercice;
    }

    public int getRepetition() {
        return repetition;
    }

    public int getTemporisation() {
        return temporisation;
    }

}

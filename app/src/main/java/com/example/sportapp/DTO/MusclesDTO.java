package com.example.sportapp.DTO;

public final class MusclesDTO {
    private final Long id;
    private final int biceps;
    private final int triceps;
    private final int avantBras;
    private final int trapezes;
    private final int dos;
    private final int pectoraux;
    private final int abdominaux;
    private final int epaules;
    private final int quadriceps;
    private final int ischios;
    private final int fessiers;
    private final int cardio;

    public MusclesDTO(Long id,
                      int biceps,
                      int triceps,
                      int avantBras,
                      int trapezes,
                      int dos,
                      int pectoraux,
                      int abdominaux,
                      int epaules,
                      int quadriceps,
                      int ischios,
                      int fessiers,
                      int cardio) {
        this.id = id;
        this.abdominaux = abdominaux;
        this.avantBras = avantBras;
        this.biceps = biceps;
        this.cardio = cardio;
        this.dos = dos;
        this.epaules = epaules;
        this.fessiers = fessiers;
        this.ischios = ischios;
        this.pectoraux = pectoraux;
        this.quadriceps = quadriceps;
        this.trapezes = trapezes;
        this.triceps = triceps;
    }

    public Long getId() {
        return id;
    }

    public int getTriceps() {
        return triceps;
    }

    public int getQuadriceps() {
        return quadriceps;
    }

    public int getIschios() {
        return ischios;
    }

    public int getFessiers() {
        return fessiers;
    }

    public int getEpaules() {
        return epaules;
    }

    public int getPectoraux() {
        return pectoraux;
    }

    public int getDos() {
        return dos;
    }

    public int getCardio() {
        return cardio;
    }

    public int getBiceps() {
        return biceps;
    }

    public int getAbdominaux() {
        return abdominaux;
    }

    public int getAvantBras() {
        return avantBras;
    }

    public int getTrapezes() {
        return trapezes;
    }
}

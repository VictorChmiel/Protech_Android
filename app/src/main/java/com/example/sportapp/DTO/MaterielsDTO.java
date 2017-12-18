package com.example.sportapp.DTO;

public final class MaterielsDTO {
    private final Long id;
    private final boolean halteres;
    private final boolean barre;
    private final boolean barreEZ;
    private final boolean barreTraction;
    private final boolean elastique;
    private final boolean poulie;
    private final boolean autre;

    public MaterielsDTO(Long id,
                        boolean halteres,
                        boolean barre,
                        boolean barreEZ,
                        boolean barreTraction,
                        boolean elastique,
                        boolean poulie,
                        boolean autre) {
        this.id = id;
        this.autre = autre;
        this.barre = barre;
        this.barreEZ = barreEZ;
        this.barreTraction = barreTraction;
        this.elastique = elastique;
        this.halteres = halteres;
        this.poulie = poulie;
    }

    public Long getId() {
        return id;
    }

    public boolean isPoulie() {
        return poulie;
    }

    public boolean isHalteres() {
        return halteres;
    }

    public boolean isElastique() {
        return elastique;
    }

    public boolean isBarreTraction() {
        return barreTraction;
    }

    public boolean isBarreEZ() {
        return barreEZ;
    }

    public boolean isBarre() {
        return barre;
    }

    public boolean isAutre() {
        return autre;
    }
}

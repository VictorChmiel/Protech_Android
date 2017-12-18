package com.example.sportapp.DTO;

import java.util.Date;
import java.util.List;

public final class SeanceDTO {
    private final Long id;
    private final int note;
    private final String date;
    private final List<ActiviteDTO> activites;

    public SeanceDTO(Long id, int note, String date, List<ActiviteDTO> activites) {
        this.id = id;
        this.note = note;
        this.date = date;
        this.activites = activites;
    }

    public Long getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public List<ActiviteDTO> getActivites() {
        return activites;
    }
}

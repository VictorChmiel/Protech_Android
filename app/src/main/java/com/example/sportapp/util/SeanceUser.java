package com.example.sportapp.util;

import com.example.sportapp.DTO.ActiviteDTO;
import com.example.sportapp.DTO.SeanceDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by corentin on 18/12/17.
 */

public class SeanceUser {

    private static Long id;
    private static int note;
    private static String date;
    private static List<ActiviteDTO> activites;
    private static int currentActivity;

    public SeanceUser() {
    }

    public static void setSeanceUser(SeanceDTO seanceDTO) {
        SeanceUser.id = seanceDTO.getId();
        SeanceUser.note = seanceDTO.getNote();
        SeanceUser.date = seanceDTO.getDate();
        SeanceUser.activites = seanceDTO.getActivites();
        SeanceUser.currentActivity=0;
    }


    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        SeanceUser.id = id;
    }

    public static int getNote() {
        return note;
    }

    public static void setNote(int note) {
        SeanceUser.note = note;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        SeanceUser.date = date;
    }

    public static List<ActiviteDTO> getActivites() {
        return activites;
    }

    public static void setActivites(List<ActiviteDTO> activites) {
        SeanceUser.activites = activites;
    }

    public static int getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(int currentActivity) {
        SeanceUser.currentActivity = currentActivity;
    }
}

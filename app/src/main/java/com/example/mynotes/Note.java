package com.example.mynotes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "my_notes")
public class Note {
    private String Title;
    private String Disc;

    public Note(String title, String disc) {
        this.Title = title;
        this.Disc = disc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = Title;
    }

    public String getDisc() {
        return Disc;
    }

    public void setDisc(String disc) {
        this.Disc = Disc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

}

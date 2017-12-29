package com.musicservicepoc.model;

public class MusicModel {

    private int musicId;
    private String musicName;
    private String autor;

    public MusicModel() {
    }

    public MusicModel(int musicId, String musicName, String autor) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.autor = autor;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

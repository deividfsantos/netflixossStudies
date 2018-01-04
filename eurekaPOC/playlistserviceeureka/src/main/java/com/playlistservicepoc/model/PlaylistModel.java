package com.playlistservicepoc.model;

import java.util.List;

public class PlaylistModel {

    private List<Integer> musicsId;
    private String playListName;

    public PlaylistModel() {
    }

    public PlaylistModel(List<Integer> musicsId, String playListName) {
        this.musicsId = musicsId;
        this.playListName = playListName;
    }

    public List<Integer> getMusicsId() {
        return musicsId;
    }

    public void setMusicsId(List<Integer> musicsId) {
        this.musicsId = musicsId;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

}

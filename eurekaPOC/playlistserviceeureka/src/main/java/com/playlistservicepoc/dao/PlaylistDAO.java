package com.playlistservicepoc.dao;

import com.playlistservicepoc.model.PlaylistModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaylistDAO {

    private final List<PlaylistModel> playlistModels = new ArrayList<>();

    public PlaylistDAO() {
        List<Integer> listMetal = new ArrayList<>();
        listMetal.add(2);
        listMetal.add(3);
        listMetal.add(5);
        PlaylistModel playlistMetalModel = new PlaylistModel(listMetal, "metal");

        List<Integer> listRock = new ArrayList<>();
        listRock.add(1);
        listRock.add(4);
        PlaylistModel playlistRockModel = new PlaylistModel(listRock, "rock");

        playlistModels.add(playlistRockModel);
        playlistModels.add(playlistMetalModel);
    }

    public List<PlaylistModel> getPlaylistModels() {
        return playlistModels;
    }

    public PlaylistModel getPlayListByName(String name){

        PlaylistModel playlistModel = new PlaylistModel();

        for (PlaylistModel playlist: playlistModels) {

            if(playlist.getPlayListName().equalsIgnoreCase(name)) {
                playlistModel = playlist;
            }

        }

        return playlistModel;
    }
}

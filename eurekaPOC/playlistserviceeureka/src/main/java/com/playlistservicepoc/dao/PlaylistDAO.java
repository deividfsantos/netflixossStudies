package com.playlistservicepoc.dao;

import com.playlistservicepoc.exception.APINotFoundException;
import com.playlistservicepoc.model.PlaylistModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaylistDAO {

    private final List<PlaylistModel> playlistModels;

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

        playlistModels = new ArrayList<PlaylistModel>();
        playlistModels.add(playlistRockModel);
        playlistModels.add(playlistMetalModel);
    }

    public List<PlaylistModel> getPlaylistModels() {
        return playlistModels;
    }

    public PlaylistModel getPlayListByName(String name){
        return playlistModels.stream()
                .filter(playlistModel -> playlistModel.getPlayListName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(APINotFoundException::new);
    }


}

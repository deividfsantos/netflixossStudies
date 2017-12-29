package com.musicservicepoc.dao;

import com.musicservicepoc.model.MusicModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicDAO {

    private final List<MusicModel> musicModels= new ArrayList<>();

    public MusicDAO() {
        musicModels.add(new MusicModel(1, "Whole Lotta Love", "Led Zeppelin"));
        musicModels.add(new MusicModel(2, "Peace Sells", "Megadeth"));
        musicModels.add(new MusicModel(3, "Drink", "Alestorm"));
        musicModels.add(new MusicModel(4, "Hóstia", "O rappa"));
        musicModels.add(new MusicModel(5, "There in", "Dark Tranquillity"));
    }

    public List<MusicModel> getMusicModels() {
        return musicModels;
    }

    public MusicModel getMusicById(int musicId){
        return musicModels.get(musicId-1);
    }

}

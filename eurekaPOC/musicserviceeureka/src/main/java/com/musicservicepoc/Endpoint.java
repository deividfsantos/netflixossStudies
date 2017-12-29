package com.musicservicepoc;


import com.musicservicepoc.dao.MusicDAO;
import com.musicservicepoc.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("music/v1")
public class Endpoint {

    @Autowired
    MusicDAO musicDAO;

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MusicModel> getAllMusics() {
        return musicDAO.getMusicModels();
    }

    @RequestMapping(value = "/{musicId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicModel getMusicById(@PathVariable(value = "musicId") Integer musicId) {
        return musicDAO.getMusicById(musicId);
    }
}
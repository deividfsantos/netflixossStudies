package com.playlistservicepoc;

import com.playlistservicepoc.dao.PlaylistDAO;
import com.playlistservicepoc.model.PlaylistModel;
import com.playlistservicepoc.service.PlaylistService;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.playlistservicepoc.model.MusicModel;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("playlist/v1")
public class Endpoint {

    @Autowired
    PlaylistDAO playlistDAO;

    @Autowired
    PlaylistService playlistService;

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlaylistModel> getAllPlaylistModels() throws IOException {
        return playlistDAO.getPlaylistModels();
    }

    @RequestMapping(value = "/{playListName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PlaylistModel getPlayListByName(@PathVariable(value = "playListName") String playListName) {
        return playlistDAO.getPlayListByName(playListName);
    }


    @RequestMapping(value = "/full/{playListName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MusicModel> getFullPlaylist(@PathVariable(value = "playListName") String playListName){
        return playlistService.findAllMusics(playListName);
    }

}
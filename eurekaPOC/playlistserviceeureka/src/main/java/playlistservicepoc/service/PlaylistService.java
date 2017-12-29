package playlistservicepoc.service;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import playlistservicepoc.Connector;
import playlistservicepoc.dao.PlaylistDAO;
import playlistservicepoc.model.MusicModel;
import playlistservicepoc.model.PlaylistModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private Connector connector = new Connector();

    @Autowired
    private PlaylistDAO playlistDAO;

    public List<MusicModel> findAllMusics(String name) throws IOException, ParseException {

        PlaylistModel playlistModel = playlistDAO.getPlayListByName(name);
        List<MusicModel> musicModels = new ArrayList<>();

        for (int i = 0; i < playlistModel.getMusicsId().size(); i++) {
            musicModels.add(findAllMusicsOnPlaylist(playlistModel.getMusicsId().get(i)));
        }

        return musicModels;
    }

    public MusicModel findAllMusicsOnPlaylist(int musicId) throws IOException, ParseException {
        return connector.run("http://localhost:9000/music/v1/"+musicId);
    }


}

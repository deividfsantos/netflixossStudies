package playlistservicepoc.service;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playlistservicepoc.eureka.Connector;
import playlistservicepoc.dao.PlaylistDAO;
import playlistservicepoc.eureka.EurekaDiscovery;
import playlistservicepoc.eureka.EurekaModelDiscover;
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

    private EurekaDiscovery eurekaDiscovery = new EurekaDiscovery();

    public List<MusicModel> findAllMusics(String name) throws IOException, ParseException, JSONException {

        PlaylistModel playlistModel = playlistDAO.getPlayListByName(name);
        List<MusicModel> musicModels = new ArrayList<>();

        for (int i = 0; i < playlistModel.getMusicsId().size(); i++) {
            musicModels.add(findAllMusicsOnPlaylist(playlistModel.getMusicsId().get(i)));
        }

        return musicModels;
    }

    public MusicModel findAllMusicsOnPlaylist(int musicId) throws IOException, ParseException, JSONException {

        List<EurekaModelDiscover> eurekaModelDiscoverList = eurekaDiscovery.getUrlFromMusicService();
        String url = eurekaModelDiscoverList.get(0).getIpAddr()+":"+eurekaModelDiscoverList.get(0).getPort();

        return connector.run("http://"+url+ "/music/v1/" + musicId);
    }


}

package com.playlistservicepoc.service;

import com.playlistservicepoc.dao.PlaylistDAO;
import com.playlistservicepoc.eureka.EurekaDiscovery;
import com.playlistservicepoc.eureka.EurekaModelDiscover;
import com.playlistservicepoc.model.PlaylistModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.playlistservicepoc.connector.MusicServiceConnector;
import com.playlistservicepoc.model.MusicModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired
    private MusicServiceConnector musicServiceConnector;

    @Autowired
    private PlaylistDAO playlistDAO;

    @Autowired
    private EurekaDiscovery eurekaDiscovery;

    public List<MusicModel> findAllMusics(String name) {
        return playlistDAO
                .getPlayListByName(name)
                .getMusicsId()
                .stream()
                .map(id -> { return findOneMusicOnPlaylist(id); })
                .collect(Collectors.toList());
    }

    public MusicModel findOneMusicOnPlaylist(int musicId) {

        List<EurekaModelDiscover> eurekaModelDiscoverList = eurekaDiscovery.getUrlFromMusicService();

        String url = eurekaModelDiscoverList.get(0).getIpAddr() + ":" + eurekaModelDiscoverList.get(0).getPort();

        return musicServiceConnector.run("http://" + url + "/music/v1/" + musicId);
    }

}

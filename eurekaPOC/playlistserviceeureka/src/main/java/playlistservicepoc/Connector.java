package playlistservicepoc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import org.json.simple.parser.ParseException;
import playlistservicepoc.model.MusicModel;

import java.io.IOException;

public class Connector {

    OkHttpClient client = new OkHttpClient();

    public MusicModel run(String url) throws IOException, ParseException {

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }

        String jsonString = responses.body().string();

        Gson gson = new GsonBuilder().create();
        MusicModel musicModel = new MusicModel();

        return musicModel = gson.fromJson(jsonString,MusicModel.class);
    }

}
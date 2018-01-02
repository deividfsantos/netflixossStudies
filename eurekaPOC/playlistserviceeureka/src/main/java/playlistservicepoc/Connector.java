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


        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"{\n" +
                "        \"instance\": {\n" +
                "        \"hostName\": \"playlist\",\n" +
                "                \"app\": \"playlistservice\",\n" +
                "                \"vipAddress\": \"com.playlistservicepoc\",\n" +
                "                \"secureVipAddress\": \"com.playlistservicepoc\",\n" +
                "                \"ipAddr\": \"127.0.0.1\",\n" +
                "                \"status\": \"UP\",\n" +
                "                \"port\": {\"$\": \"9001\", \"@enabled\": \"true\"},\n" +
                "        \"securePort\": {\"$\": \"9001\", \"@enabled\": \"true\"},\n" +
                "        \"healthCheckUrl\": \"http://localhost:9001/playlist/v1/\",\n" +
                "                \"statusPageUrl\": \"http://localhost:9001/playlist/v1/\",\n" +
                "                \"homePageUrl\": \"http://localhost:9001/playlist/v1/\",\n" +
                "                \"dataCenterInfo\": {\n" +
                "            \"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\",\n" +
                "                    \"name\": \"MyOwn\"\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "}\n") ;
        Request request2 = new Request.Builder().url("http://localhost:8080/eureka/v2/apps/playlistservice").post(body).build() ;
        Response response = client.newCall(request2).execute() ;


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
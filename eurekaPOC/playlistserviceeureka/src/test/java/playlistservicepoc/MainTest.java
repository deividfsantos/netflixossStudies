package playlistservicepoc;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
import com.netflix.discovery.DiscoveryClient;
import okhttp3.*;
import okio.BufferedSink;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by HuanagYueWen on 2016-12-11.
 */
public class MainTest {


    @Test
    public void testEureka(){
        EurekaInstanceConfig instanceConfig = new MyDataCenterInstanceConfig();
        InstanceInfo instanceInfo = new EurekaConfigBasedInstanceInfoProvider(instanceConfig).get();
        ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(instanceConfig, instanceInfo);
//        ApplicationInfoManager manager = new ApplicationInfoManager() ;

        Assert.assertEquals("eurekaTestApp".toUpperCase(),applicationInfoManager.getInfo().getAppName());
//        DiscoveryClient
    }


    @Test
    public void testEurekaRegistry(){

//        InstanceInfo info = new InstanceInfo("123456","eurekaApp","192.168.101.111","8888",) ;

        DiscoveryClient client =  null ;
//        client.in


        OkHttpClient httpClient = new OkHttpClient() ;
        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json"),"") ;
            Request request = new Request.Builder().url("http://localhost:8080/eureka/v2/apps/playlistservice").post(body).build() ;
            Response response = httpClient.newCall(request).execute() ;
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
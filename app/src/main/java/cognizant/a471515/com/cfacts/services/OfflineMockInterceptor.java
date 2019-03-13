package cognizant.a471515.com.cfacts.services;

import java.io.IOException;
import java.util.Map;

import cognizant.a471515.com.cfacts.FactsUtils;
import cognizant.a471515.com.cfacts.models.OfflineModeMap;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OfflineMockInterceptor implements Interceptor {

    private static final MediaType MEDIA_JSON = MediaType.parse("application/json");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String path = request.url().encodedPath();
        String responseString = "";
        FactsUtils factsUtils = new FactsUtils();
        String jsonResponse = factsUtils.loadJsonFromRaw("offlinemodemap.json");
        OfflineModeMap offlineModeMap = (OfflineModeMap)factsUtils.constructUsingGson(jsonResponse,OfflineModeMap.class);
        for(Map.Entry<String,String> urlMappingJson : offlineModeMap.getOfflinemodemap().entrySet()){
            if(path.contains(urlMappingJson.getKey())){
                responseString = factsUtils.loadJsonFromRaw(urlMappingJson.getValue() + ".json");
                break;
            }
        }
       Response response = new Response.Builder()
               .body(ResponseBody.create(MEDIA_JSON,responseString))
               .request(chain.request())
               .code(200)
               .build();

        return response;
    }
}

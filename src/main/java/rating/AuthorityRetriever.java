package rating;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Created by weiluo on 20/05/15.
 */
public class AuthorityRetriever {
    public String getAuthoritiesAsString() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String result=null;
        try {
            HttpHost target = new HttpHost("api.ratings.food.gov.uk", 80, "http");
            HttpGet getRequest = new HttpGet("/Authorities");
            getRequest.addHeader("Accept", "application/json");
            getRequest.addHeader("x-api-version", "2");
            HttpResponse httpResponse = httpClient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                result = IOUtils.toString(entity.getContent(), "UTF-8");
            }
        } finally {
            httpClient.close();
        }
        return result;
    }

    public List<Authority> parseAuthorities() throws IOException {
        String authoritiesAsString = getAuthoritiesAsString();

        JsonElement element = new JsonParser().parse(authoritiesAsString);
        JsonObject object = element.getAsJsonObject();
        JsonArray authorities = object.getAsJsonArray("authorities");
        for(int i=0;i<authorities.size();i++){
            JsonObject authority = authorities.get(i).getAsJsonObject();
            authority.get("LocalAuthorityId").toString();
            authority.get("Name").toString();
        }

//        object = jarray.get(0).getAsJsonObject();
//        String result = object.get("translatedText").toString();

        return null;
    }

}

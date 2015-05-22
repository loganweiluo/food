package rating.authority;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rating.httpClient.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiluo on 20/05/15.
 */
public class AuthorityService {

    private HttpClient client;

    public AuthorityService(HttpClient client) {
        this.client = client;
    }

    public List<Authority> getAuthorities() throws IOException {
        ArrayList<Authority> result = new ArrayList<>();

        String authoritiesJsonString = client.getAuthoritiesJsonString();
        JsonElement element = new JsonParser().parse(authoritiesJsonString);
        JsonObject object = element.getAsJsonObject();
        JsonArray authorities = object.getAsJsonArray("authorities");
        for (int i = 0; i < authorities.size(); i++) {
            JsonObject authority = authorities.get(i).getAsJsonObject();
            String id = authority.get("LocalAuthorityId").toString();
            String name = authority.get("Name").toString();
            name = name.replace("\"", "");
            result.add(new Authority(id, name));
        }
        return result;
    }

}

package rating.establishment;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rating.httpClient.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiluo on 22/05/15.
 */
public class EstablishmentService {
    private HttpClient client;

    public EstablishmentService(HttpClient client) {
        this.client = client;
    }

    /**
     * Retrieves a list of Establishments.
     *
     * @param localAuthorityId the id of local authority.
     * @return a list of Establishments containing rating values.
     * @throws IOException
     */
    public List<Establishment> getEstablishments(String localAuthorityId) throws IOException {
        String establishmentsJsonString = client.getEstablishmentsJsonString(localAuthorityId);
        return parseEstablishmentJsonString(establishmentsJsonString);
    }

    private List<Establishment> parseEstablishmentJsonString(String establishmentsJsonString) {
        ArrayList<Establishment> result = new ArrayList<>();
        JsonElement element = new JsonParser().parse(establishmentsJsonString);
        JsonObject object = element.getAsJsonObject();
        JsonArray authorities = object.getAsJsonArray("establishments");
        for (int i = 0; i < authorities.size(); i++) {
            JsonObject authority = authorities.get(i).getAsJsonObject();
            String ratingValue = authority.get("RatingValue").toString();
            ratingValue = ratingValue.replace("\"", "");
            result.add(new Establishment(ratingValue));
        }
        return result;
    }
}

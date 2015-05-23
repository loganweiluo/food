package rating.httpClient;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Created by weiluo on 22/05/15.
 */

/**
 * Makes API call.
 */
public class HttpClient {

    public static final String ROOT_URL = "api.ratings.food.gov.uk";
    public static final String AUTHORITIES = "/Authorities";
    public static final String ESTABLISHMENTS = "/Establishments?localAuthorityId=";

    private String getContent(String requestURL) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String result = null;
        try {
            HttpHost target = new HttpHost(ROOT_URL, 80, "http");
            HttpGet getRequest = new HttpGet(requestURL);
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

    /**
     * Retrieves information of authorities.
     * @return a json string that contains information of authorities.
     * @throws IOException
     */
    public String getAuthoritiesJsonString() throws IOException {
        return getContent(AUTHORITIES);
    }

    /**
     * Retrieves information of establishments.
     * @param localAuthorityId id of local authority.
     * @return a json string that contains information of establishments.
     * @throws IOException
     */
    public String getEstablishmentsJsonString(String localAuthorityId) throws IOException {
        if(localAuthorityId==null || localAuthorityId.isEmpty()){
            throw new IllegalArgumentException("Local authority id must not be empty.");
        }
        return getContent(ESTABLISHMENTS + localAuthorityId);
    }
}

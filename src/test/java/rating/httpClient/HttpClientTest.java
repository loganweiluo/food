package rating.httpClient;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by weiluo on 22/05/15.
 */
public class HttpClientTest {
    HttpClient client = new HttpClient();

    @Test
    public void shouldGetAuthoritiesAsJsonString() throws IOException {
        String authoritiesJsonString = client.getAuthoritiesJsonString();
        assertTrue(authoritiesJsonString != null);
        assertTrue(authoritiesJsonString.length() > 0);
        assertTrue(authoritiesJsonString.contains("authorities"));
    }

    @Test
    public void shouldGetEstablishmentsAsJsonString() throws IOException {
        String establishmentsJsonString = client.getEstablishmentsJsonString("197");
        assertTrue(establishmentsJsonString != null);
        assertTrue(establishmentsJsonString.length() > 0);

        System.out.println(establishmentsJsonString);
//        assertTrue(establishmentsJsonString.contains("authorities"));
    }
}

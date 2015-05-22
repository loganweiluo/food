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
}

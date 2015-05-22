package rating;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by weiluo on 20/05/15.
 */
public class AuthorityRetrieverTest {

    AuthorityRetriever retriever = new AuthorityRetriever();

    @Test
    public void shouldRetrieveAuthorities() throws IOException {
        String authoritiesAsString = retriever.getAuthoritiesAsString();
        assertTrue(authoritiesAsString != null);
        assertTrue(authoritiesAsString.length() > 0);
    }
}

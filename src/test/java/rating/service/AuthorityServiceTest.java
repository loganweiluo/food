package rating.service;

import org.junit.Test;
import rating.model.Authority;
import rating.service.AuthorityService;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by weiluo on 20/05/15.
 */
public class AuthorityServiceTest {

    AuthorityService authorityService = new AuthorityService();

    @Test
    public void shouldRetrieveAuthorities() throws IOException {
        String authoritiesAsString = authorityService.getAuthoritiesAsString();
        assertTrue(authoritiesAsString != null);
        assertTrue(authoritiesAsString.length() > 0);
    }

    @Test
    public void shouldGetAuthorities() throws IOException {
        List<Authority> authorities = authorityService.getAuthorities();
        assertTrue(authorities.size() > 0);
    }
}

package rating.service;

import org.junit.Before;
import org.junit.Test;
import rating.authority.Authority;
import rating.authority.AuthorityService;
import rating.httpClient.HttpClient;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by weiluo on 20/05/15.
 */
public class AuthorityServiceTest {

    private static final String AUTHORITY_JSON_STUB =
            "{\"authorities\": [" +
            "    {" +
            "        \"LocalAuthorityId\": 197," +
            "        \"LocalAuthorityIdCode\": \"760\"," +
            "        \"Name\": \"Aberdeen City\"," +
            "        \"FriendlyName\": \"aberdeen-city\"," +
            "        \"Url\": \"http://www.aberdeencity.gov.uk\"," +
            "        \"SchemeUrl\": \"\"," +
            "        \"Email\": \"commercial@aberdeencity.gov.uk\"," +
            "        \"RegionName\": \"Scotland\"," +
            "        \"FileName\": \"http://ratings.food.gov.uk/OpenDataFiles/FHRS760en-GB.xml\"," +
            "        \"FileNameWelsh\": null," +
            "        \"EstablishmentCount\": 1694," +
            "        \"CreationDate\": \"2010-08-17T15:30:24.87\"," +
            "        \"LastPublishedDate\": \"2015-04-15T08:38:47.573\"," +
            "        \"SchemeType\": 2," +
            "        \"links\": [" +
            "            {" +
            "                \"rel\": \"self\"," +
            "                \"href\": \"http://api.ratings.food.gov.uk/authorities/197\"" +
            "            }" +
            "        ]" +
            "    }," +
            "    {" +
            "        \"LocalAuthorityId\": 198," +
            "        \"LocalAuthorityIdCode\": \"761\"," +
            "        \"Name\": \"Aberdeenshire\"," +
            "        \"FriendlyName\": \"aberdeenshire\"," +
            "        \"Url\": \"http://www.aberdeenshire.gov.uk/\"," +
            "        \"SchemeUrl\": \"\"," +
            "        \"Email\": \"environmental@aberdeenshire.gov.uk\"," +
            "        \"RegionName\": \"Scotland\"," +
            "        \"FileName\": \"http://ratings.food.gov.uk/OpenDataFiles/FHRS761en-GB.xml\"," +
            "        \"FileNameWelsh\": null," +
            "        \"EstablishmentCount\": 1965," +
            "        \"CreationDate\": \"2010-08-17T15:30:24.87\"," +
            "        \"LastPublishedDate\": \"2015-05-20T00:34:10.6\"," +
            "        \"SchemeType\": 2," +
            "        \"links\": [" +
            "            {" +
            "                \"rel\": \"self\"," +
            "                \"href\": \"http://api.ratings.food.gov.uk/authorities/198\"" +
            "            }" +
            "        ]" +
            "    }," +
            "    {" +
            "        \"LocalAuthorityId\": 277," +
            "        \"LocalAuthorityIdCode\": \"323\"," +
            "        \"Name\": \"Adur\"," +
            "        \"FriendlyName\": \"adur\"," +
            "        \"Url\": \"http://www.adur-worthing.gov.uk\"," +
            "        \"SchemeUrl\": \"\"," +
            "        \"Email\": \"envsupport@adur-worthing.gov.uk\"," +
            "        \"RegionName\": \"South East\"," +
            "        \"FileName\": \"http://ratings.food.gov.uk/OpenDataFiles/FHRS323en-GB.xml\"," +
            "        \"FileNameWelsh\": null," +
            "        \"EstablishmentCount\": 390," +
            "        \"CreationDate\": \"2010-08-17T15:30:24.87\"," +
            "        \"LastPublishedDate\": \"2015-05-20T00:32:58.853\"," +
            "        \"SchemeType\": 1," +
            "        \"links\": [" +
            "            {" +
            "                \"rel\": \"self\"," +
            "                \"href\": \"http://api.ratings.food.gov.uk/authorities/277\"" +
            "            }" +
            "        ]" +
            "    }," +
            "    {" +
            "        \"LocalAuthorityId\": 158," +
            "        \"LocalAuthorityIdCode\": \"055\"," +
            "        \"Name\": \"Allerdale\"," +
            "        \"FriendlyName\": \"allerdale\"," +
            "        \"Url\": \"http://www.allerdale.gov.uk\"," +
            "        \"SchemeUrl\": \"\"," +
            "        \"Email\": \"environmental.health@allerdale.gov.uk\"," +
            "        \"RegionName\": \"North West\"," +
            "        \"FileName\": \"http://ratings.food.gov.uk/OpenDataFiles/FHRS055en-GB.xml\"," +
            "        \"FileNameWelsh\": null," +
            "        \"EstablishmentCount\": 1095," +
            "        \"CreationDate\": \"2010-08-17T15:30:24.87\"," +
            "        \"LastPublishedDate\": \"2015-05-19T00:32:01.627\"," +
            "        \"SchemeType\": 1," +
            "        \"links\": [" +
            "            {" +
            "                \"rel\": \"self\"," +
            "                \"href\": \"http://api.ratings.food.gov.uk/authorities/158\"" +
            "            }" +
            "        ]" +
            "    }" +
            "]}";

    private HttpClient httpClient;

    private AuthorityService authorityService;

    @Before
    public void before() throws IOException {
        httpClient = mock(HttpClient.class);
        when(httpClient.getAuthoritiesJsonString()).thenReturn(AUTHORITY_JSON_STUB);
        authorityService = new AuthorityService(httpClient);

    }

    @Test
    public void shouldGetAuthorities() throws IOException {
        List<Authority> authorities = authorityService.getAuthorities();
        assertEquals(4, authorities.size());
    }
}

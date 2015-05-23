package rating.establishment;

import org.junit.Before;
import org.junit.Test;
import rating.httpClient.HttpClient;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by weiluo on 23/05/15.
 */
public class EstablishmentServiceTest {
    private static final String ESTABLISHMENT_JSON_SAMPLE =
            "{\"establishments\": [" +
                    "    {" +
                    "        \"FHRSID\": 150309," +
                    "        \"LocalAuthorityBusinessID\": \"9793\"," +
                    "        \"BusinessName\": \"210 BISTRO\"," +
                    "        \"BusinessType\": \"Restaurant/Cafe/Canteen\"," +
                    "        \"BusinessTypeID\": 1," +
                    "        \"AddressLine1\": \"\"," +
                    "        \"AddressLine2\": \"210 Market Street\"," +
                    "        \"AddressLine3\": \"Aberdeen\"," +
                    "        \"AddressLine4\": \"\"," +
                    "        \"PostCode\": \"AB11 5PQ\"," +
                    "        \"Phone\": \"\"," +
                    "        \"RatingValue\": \"Pass\"," +
                    "        \"RatingKey\": \"fhis_pass_en-gb\"," +
                    "        \"RatingDate\": \"2014-10-04T00:00:00\"," +
                    "        \"LocalAuthorityCode\": \"760\"," +
                    "        \"LocalAuthorityName\": \"Aberdeen City\"," +
                    "        \"LocalAuthorityWebSite\": \"http://www.aberdeencity.gov.uk\"," +
                    "        \"LocalAuthorityEmailAddress\": \"commercial@aberdeencity.gov.uk\"," +
                    "        \"scores\": {" +
                    "            \"Hygiene\": null," +
                    "            \"Structural\": null," +
                    "            \"ConfidenceInManagement\": null" +
                    "        }," +
                    "        \"SchemeType\": \"FHIS\"," +
                    "        \"geocode\": {" +
                    "            \"longitude\": \"-2.092258\"," +
                    "            \"latitude\": \"57.142278\"" +
                    "        }," +
                    "        \"RightToReply\": \"\"," +
                    "        \"Distance\": null," +
                    "        \"NewRatingPending\": false," +
                    "        \"links\": []" +
                    "    }," +
                    "    {" +
                    "        \"FHRSID\": 118409," +
                    "        \"LocalAuthorityBusinessID\": \"4774\"," +
                    "        \"BusinessName\": \"22 CLUB\"," +
                    "        \"BusinessType\": \"Pub/bar/nightclub\"," +
                    "        \"BusinessTypeID\": 7843," +
                    "        \"AddressLine1\": \"\"," +
                    "        \"AddressLine2\": \"55 Rose Street\"," +
                    "        \"AddressLine3\": \"Aberdeen\"," +
                    "        \"AddressLine4\": \"\"," +
                    "        \"PostCode\": \"AB10 1UB\"," +
                    "        \"Phone\": \"\"," +
                    "        \"RatingValue\": \"Pass\"," +
                    "        \"RatingKey\": \"fhis_pass_en-gb\"," +
                    "        \"RatingDate\": \"2010-08-30T00:00:00\"," +
                    "        \"LocalAuthorityCode\": \"760\"," +
                    "        \"LocalAuthorityName\": \"Aberdeen City\"," +
                    "        \"LocalAuthorityWebSite\": \"http://www.aberdeencity.gov.uk\"," +
                    "        \"LocalAuthorityEmailAddress\": \"commercial@aberdeencity.gov.uk\"," +
                    "        \"scores\": {" +
                    "            \"Hygiene\": null," +
                    "            \"Structural\": null," +
                    "            \"ConfidenceInManagement\": null" +
                    "        }," +
                    "        \"SchemeType\": \"FHIS\"," +
                    "        \"geocode\": {" +
                    "            \"longitude\": \"-2.111912\"," +
                    "            \"latitude\": \"57.144562\"" +
                    "        }," +
                    "        \"RightToReply\": \"\"," +
                    "        \"Distance\": null," +
                    "        \"NewRatingPending\": false," +
                    "        \"links\": []" +
                    "    }," +
                    "    {" +
                    "        \"FHRSID\": 145060," +
                    "        \"LocalAuthorityBusinessID\": \"8497\"," +
                    "        \"BusinessName\": \"3rd HOUSE GUESTHOUSE\"," +
                    "        \"BusinessType\": \"Hotel/bed & breakfast/guest house\"," +
                    "        \"BusinessTypeID\": 7842," +
                    "        \"AddressLine1\": \"\"," +
                    "        \"AddressLine2\": \"406 Great Western Road\"," +
                    "        \"AddressLine3\": \"Aberdeen\"," +
                    "        \"AddressLine4\": \"\"," +
                    "        \"PostCode\": \"AB10 6NR\"," +
                    "        \"Phone\": \"\"," +
                    "        \"RatingValue\": \"Pass\"," +
                    "        \"RatingKey\": \"fhis_pass_en-gb\"," +
                    "        \"RatingDate\": \"2012-08-02T00:00:00\"," +
                    "        \"LocalAuthorityCode\": \"760\"," +
                    "        \"LocalAuthorityName\": \"Aberdeen City\"," +
                    "        \"LocalAuthorityWebSite\": \"http://www.aberdeencity.gov.uk\"," +
                    "        \"LocalAuthorityEmailAddress\": \"commercial@aberdeencity.gov.uk\"," +
                    "        \"scores\": {" +
                    "            \"Hygiene\": null," +
                    "            \"Structural\": null," +
                    "            \"ConfidenceInManagement\": null" +
                    "        }," +
                    "        \"SchemeType\": \"FHIS\"," +
                    "        \"geocode\": {" +
                    "            \"longitude\": \"-2.130746\"," +
                    "            \"latitude\": \"57.133935\"" +
                    "        }," +
                    "        \"RightToReply\": \"\"," +
                    "        \"Distance\": null," +
                    "        \"NewRatingPending\": false," +
                    "        \"links\": []" +
                    "    }" +
                    "]}";
    private static final String LOCAL_AUTHORITY_ID = "11";

    private HttpClient httpClient;
    private EstablishmentService establishmentService;

    @Before
    public void setup() throws IOException {
        httpClient = mock(HttpClient.class);
        when(httpClient.getEstablishmentsJsonString(LOCAL_AUTHORITY_ID)).thenReturn(ESTABLISHMENT_JSON_SAMPLE);
        establishmentService = new EstablishmentService(httpClient);
    }

    @Test
    public void shouldReturnEstablishments() throws IOException {
        List<Establishment> establishments = establishmentService.getEstablishments(LOCAL_AUTHORITY_ID);
        assertEquals(3, establishments.size());
    }
}

package rating.distribution;

import org.junit.Before;
import org.junit.Test;
import rating.establishment.Establishment;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

/**
 * Created by weiluo on 23/05/15.
 */
public class DistributionCalculatorTest {
    private DistributionCalculator distributionCalculator;

    @Before
    public void setup() {
        distributionCalculator = new DistributionCalculator();
    }

    @Test
    public void shouldReturnEmptyListWhenThereIsNoEstablishments() {
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(new ArrayList<Establishment>());
        assertEquals(0, ratingDistributions.size());
    }

    @Test
    public void shouldReturnDistributionForOnlyOneEstablishment() {
        ArrayList<Establishment> establishments = new ArrayList<>();
        String fiveStars = "five stars";
        establishments.add(new Establishment(fiveStars));
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(establishments);
        assertEquals(1, ratingDistributions.size());
        RatingDistribution ratingDistribution = ratingDistributions.get(0);
        assertEquals(fiveStars, ratingDistribution.getRatingValue());
        assertEquals(100, ratingDistribution.getPercentage(), 0);
    }

    @Test
    public void shouldReturnDistributionForTwoEstablishmentsWithSameRating() {
        ArrayList<Establishment> establishments = new ArrayList<>();
        String fiveStars = "five stars";
        establishments.add(new Establishment(fiveStars));
        establishments.add(new Establishment(fiveStars));
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(establishments);
        assertEquals(1, ratingDistributions.size());
        RatingDistribution ratingDistribution = ratingDistributions.get(0);
        assertEquals(fiveStars, ratingDistribution.getRatingValue());
        assertEquals(100, ratingDistribution.getPercentage(), 0);
    }

    @Test
    public void shouldReturnDistributionForTwoEstablishmentsWithDifferentRatings() {
        String fiveStars = "five stars";
        String fourStars = "four stars";
        List<Establishment> establishments = makeEstablishmentsWithRatingValues(fiveStars, fourStars);
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(establishments);
        assertEquals(2, ratingDistributions.size());
        RatingDistribution fourStarDistribution = new RatingDistribution(fourStars, (double) 50);
        RatingDistribution fiveStarDistribution = new RatingDistribution(fiveStars, (double) 50);
        assertThat(ratingDistributions, containsInAnyOrder(fourStarDistribution, fiveStarDistribution));
    }

    @Test
    public void shouldReturnDistributionForFiveEstablishmentsWithDifferentRatings() {
        String fiveStars = "five stars";
        String fourStars = "four stars";
        String threeStars = "three stars";
        String twoStars = "two stars";
        String oneStar = "one star";
        List<Establishment> establishments = makeEstablishmentsWithRatingValues(fiveStars, fourStars, threeStars, twoStars, oneStar);
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(establishments);
        assertEquals(5, ratingDistributions.size());
        RatingDistribution fiveStarDistribution = new RatingDistribution(fiveStars, (double) 20);
        RatingDistribution fourStarDistribution = new RatingDistribution(fourStars, (double) 20);
        RatingDistribution threeStarDistribution = new RatingDistribution(threeStars, (double) 20);
        RatingDistribution twoStarDistribution = new RatingDistribution(twoStars, (double) 20);
        RatingDistribution oneStarDistribution = new RatingDistribution(oneStar, (double) 20);
        assertThat(ratingDistributions, containsInAnyOrder(fiveStarDistribution, fourStarDistribution, threeStarDistribution, twoStarDistribution, oneStarDistribution));
    }

    @Test
    public void shouldReturnDistributionForFiveEstablishmentsWithOverlappingRatings() {
        String fiveStars = "five stars";
        String threeStars = "three stars";
        String oneStar = "one star";
        List<Establishment> establishments = makeEstablishmentsWithRatingValues(fiveStars, oneStar, threeStars, oneStar, oneStar);
        List<RatingDistribution> ratingDistributions = distributionCalculator.calculateDistribution(establishments);
        assertEquals(3, ratingDistributions.size());
        RatingDistribution fiveStarDistribution = new RatingDistribution(fiveStars, (double) 20);
        RatingDistribution threeStarDistribution = new RatingDistribution(threeStars, (double) 20);
        RatingDistribution oneStarDistribution = new RatingDistribution(oneStar, (double) 60);
        assertThat(ratingDistributions, containsInAnyOrder(fiveStarDistribution, threeStarDistribution, oneStarDistribution));
    }

    private List<Establishment> makeEstablishmentsWithRatingValues(String... values) {
        ArrayList<Establishment> establishments = new ArrayList<>();
        for (String value : values) {
            establishments.add(new Establishment(value));
        }
        return establishments;
    }


}

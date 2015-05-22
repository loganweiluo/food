package rating.distribution;

/**
 * Created by weiluo on 22/05/15.
 */
public class RatingDistribution {
    private String ratingValue;
    private double percentage;

    public RatingDistribution(String ratingValue, double percentage) {
        this.ratingValue = ratingValue;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getRatingValue() {
        return ratingValue;
    }
}

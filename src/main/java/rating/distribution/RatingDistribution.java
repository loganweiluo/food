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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingDistribution that = (RatingDistribution) o;

        if (Double.compare(that.percentage, percentage) != 0) return false;
        if (!ratingValue.equals(that.ratingValue)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ratingValue.hashCode();
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

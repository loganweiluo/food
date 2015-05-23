package rating.establishment;

/**
 * Created by weiluo on 22/05/15.
 */

/**
 * A model that presents an Establishment.
 */
public class Establishment {
    private String ratingValue;

    public Establishment(String ratingValue) {

        this.ratingValue = ratingValue;
    }

    public String getRatingValue() {
        return ratingValue;
    }
}

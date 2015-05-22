package rating.distribution;

import rating.establishment.Establishment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.round;

/**
 * Created by weiluo on 22/05/15.
 */
public class DistributionCalculator {
    public List<RatingDistribution> calculateDistribution(List<Establishment> establishments) {

        ArrayList<RatingDistribution> result = new ArrayList<>();
        Map<String, Integer> distributionCounts = new TreeMap<>();
        for (Establishment establishment : establishments) {
            String ratingValue = establishment.getRatingValue();
            if (distributionCounts.keySet().contains(ratingValue)) {
                Integer count = distributionCounts.get(ratingValue);
                distributionCounts.put(ratingValue, count + 1);
            } else {
                distributionCounts.put(ratingValue, 1);
            }
        }

        int total = establishments.size();

        if (total > 0) {
            for (Map.Entry<String, Integer> distributionCount : distributionCounts.entrySet()) {
                double percentage = (double) distributionCount.getValue() / total;
                percentage = roundTo2DecimalPlaces(percentage * 100);
                RatingDistribution distribution = new RatingDistribution(distributionCount.getKey(), percentage);
                result.add(distribution);
            }
        }

        return result;
    }

    private double roundTo2DecimalPlaces(double input) {
        int factor = 100;
        input = input * factor;
        input = round(input);
        return input / factor;
    }

}

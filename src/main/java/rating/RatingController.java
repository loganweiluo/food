package rating;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weiluo on 20/05/15.
 */
@RestController
public class RatingController {
    @RequestMapping("/authorities")
    public Authority authorities() {
        return new Authority("1", "Wei");
    }

}

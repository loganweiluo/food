package rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rating.authority.Authority;
import rating.authority.AuthorityService;

import java.io.IOException;
import java.util.List;

/**
 * Created by weiluo on 20/05/15.
 */
@RestController
public class RatingController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/authorities")
    public List<Authority> authorities() throws IOException {
        return authorityService.getAuthorities();
    }

}

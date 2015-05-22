package rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rating.authority.Authority;
import rating.authority.AuthorityService;
import rating.distribution.DistributionCalculator;
import rating.distribution.RatingDistribution;
import rating.establishment.Establishment;
import rating.establishment.EstablishmentService;

import java.io.IOException;
import java.util.List;

/**
 * Created by weiluo on 20/05/15.
 */
@RestController
public class RatingController {

    private AuthorityService authorityService;

    private EstablishmentService establishmentService;

    private DistributionCalculator distributionCalculator;

    @Autowired
    public RatingController(AuthorityService authorityService, EstablishmentService establishmentService, DistributionCalculator distributionCalculator) {
        this.authorityService = authorityService;
        this.establishmentService = establishmentService;
        this.distributionCalculator = distributionCalculator;
    }

    @RequestMapping("/authorities")
    public List<Authority> authorities() throws IOException {
        return authorityService.getAuthorities();
    }

    @RequestMapping("/ratingDistributions")
    public List<RatingDistribution> ratingDistributions(@RequestParam("localAuthorityId") String localAuthorityId) throws IOException {
        List<Establishment> establishments = establishmentService.getEstablishments(localAuthorityId);
        return distributionCalculator.calculateDistribution(establishments);
    }

}

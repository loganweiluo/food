package rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rating.service.AuthorityService;

/**
 * Created by weiluo on 20/05/15.
 */
@SpringBootApplication
@Configuration
public class Application {

    @Bean
    public AuthorityService authorityService(){
        return new AuthorityService();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

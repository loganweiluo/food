package rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rating.authority.AuthorityService;
import rating.httpClient.HttpClient;

/**
 * Created by weiluo on 20/05/15.
 */
@SpringBootApplication
@Configuration
public class Application {

    @Bean
    public AuthorityService authorityService(){
        return new AuthorityService(httpClient());
    }

    @Bean
    public HttpClient httpClient(){
        return new HttpClient();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

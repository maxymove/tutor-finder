package app.tutorfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class TutorFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorFinderApplication.class, args);
    }

}

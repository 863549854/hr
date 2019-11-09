package cn.rails.hr.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.WebApplicationInitializer;
@EnableEurekaServer
@SpringBootApplication
public class HrEurekaApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    public static void main(String[] args){
        SpringApplication.run(HrEurekaApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HrEurekaApplication.class);
    }
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(http);
        }
    }

}

/*
public class EurekaApplication
 extends SpringBootServletInitializer implements WebApplicationInitializer

    {
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EurekaApplication.class);
    }
    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }
    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(EurekaApplication.class).bannerMode(Banner.Mode.OFF);
    }
}
*/

package com.chrisgruber.nanourl;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class NanourlSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/u").permitAll()
                .antMatchers(HttpMethod.GET, "/u/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/urlalias").authenticated()
                .antMatchers(HttpMethod.GET, "/api/urlalias/").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/urlalias/").authenticated()
                .antMatchers(HttpMethod.POST, "/api/urlalias/").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/urlalias/").authenticated()
                .antMatchers(HttpMethod.GET, "/api/userprofile/").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/userprofile/").authenticated()
                .antMatchers(HttpMethod.POST, "/api/userprofile/").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/userprofile/").authenticated();
    }
}

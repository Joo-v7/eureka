package com.chokchok.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = false)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 보호를 비활성화
        http.csrf(AbstractHttpConfigurer::disable);

        // 모든 요청에 대해 인증이 필요하다고 지정
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        );

        // HTTP Basic 인증을 활성화
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}

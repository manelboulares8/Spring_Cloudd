package com.manel.gatewayserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import reactor.core.publisher.Mono;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    /* @Bean
     public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity
                                                                     serverHttpSecurity) {
         serverHttpSecurity.authorizeExchange(exchanges -> //exchanges.pathMatchers(HttpMethod.GET).authenticated()
                                 exchanges.pathMatchers("/api/ins/**").hasRole("ADMIN")
                         .pathMatchers("/api/etudiants/**").authenticated())
                 .oauth2ResourceServer(oAuth2ResourceServerSpec ->
                         oAuth2ResourceServerSpec
                                 .jwt(Customizer.withDefaults()));

         serverHttpSecurity.csrf(csrfSpec -> csrfSpec.disable());
         return serverHttpSecurity.build();
     }
 */
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http.authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/ins/**").hasRole("ADMIN")
                        .pathMatchers("/api/etudiants/**").hasRole("ETUDIANT")
                        .anyExchange().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(grantedAuthoritiesExtractor()))
                );

        http.csrf(ServerHttpSecurity.CsrfSpec::disable);

        return http.build();
    }

    private org.springframework.core.convert.converter.Converter<Jwt, Mono<AbstractAuthenticationToken>>
    grantedAuthoritiesExtractor() {

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        return new ReactiveJwtAuthenticationConverterAdapter(converter);
    }
}

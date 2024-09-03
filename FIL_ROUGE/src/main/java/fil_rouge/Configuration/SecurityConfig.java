package fil_rouge.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Cros-Site-Request-Forgery
        http
                .csrf( csrf -> csrf.disable()) // desactivation du CSRF pour tous les requetes http(GET-POST-PUT....)
                // Configuration des autorisations des requêtes HTTP
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/auth/registerAdmin","/api/v1/auth/authenticate")
                        .permitAll()
                        .requestMatchers("/api/v1/auth/User/**").hasAuthority("DONNEURSANG")
                        .requestMatchers("/api/v1/auth/Admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/v1/auth/SECRETAIRE/**").hasAuthority("SECRETAIRE")
                        .anyRequest()
                        .authenticated()
                )
                // Gestion des sessions
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ) // l'app ne doit pas utiliser de sessions HTTP pour stocker l'état de l'auth
                //Configuration du fournisseur d'authentification
                .authenticationProvider(authenticationProvider)
                //Ajout d'un filtre personnalisé
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        //Construit et retourne l'objet SecurityFilterChain basé sur la configuration définie.
        return http.build();

    }
}
package fi.joniharju.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .anyRequest().authenticated())
                                .formLogin(formlogin -> formlogin
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/booklist", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .permitAll());
                return http.build();

        }

        // @Bean
        // public UserDetailsService userDetailsService() {
        // UserDetails user = User.withDefaultPasswordEncoder()
        // .username("user")
        // .password("password")
        // .roles("USER")
        // .build();

        // UserDetails admin = User.withDefaultPasswordEncoder()
        // .username("admin")
        // .password("password")
        // .roles("ADMIN")
        // .build();
        // List<UserDetails> users = new ArrayList<>();
        // users.add(user);
        // users.add(admin);

        // return new InMemoryUserDetailsManager(users);

        // }
}

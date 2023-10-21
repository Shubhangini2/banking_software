package banking_software.banking_software.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    @Bean
    public PasswordEncoder getPassWordEncoder(){

        return new BCryptPasswordEncoder(); //it is the child of passwordEncode
    }


    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder().username("user")
                .password(getPassWordEncoder().encode("user123"))
                .roles("USER")
                .build();

        //Store these two in IN-MEMORY
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**")//define end point for public api /public/-- ** means it can be anything
                .hasAnyRole("USER")
                .anyRequest()
                .authenticated() //every request apart from public will be authenticated
                .and()
                .formLogin();

        return httpSecurity.build(); //it is the child class of securityFilterChain
    }

}

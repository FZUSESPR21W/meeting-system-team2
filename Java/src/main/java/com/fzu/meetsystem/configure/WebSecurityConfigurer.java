package com.fzu.meetsystem.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Value("${system.user.password.secret}")
    private String secret=null;
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        PasswordEncoder encoder= new Pbkdf2PasswordEncoder(secret);
        return encoder;
    }

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsService userDetailService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userDetailService)
                .passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable();
        http.cors().disable();
        http.formLogin().disable();
        http.logout().disable();

        http.authorizeRequests()
                .antMatchers("/api/logout").authenticated()
                .anyRequest().permitAll();
        http.rememberMe().alwaysRemember(true);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}

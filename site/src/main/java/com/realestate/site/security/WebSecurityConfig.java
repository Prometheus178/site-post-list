package com.realestate.site.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//
//    @Autowired
//    @Qualifier("myRequestCache")
//    RequestCache myRequestCache;

////    @Autowired
//    @Qualifier("myAccessDeniedHandler")

    private final AccessDeniedHandler accessDeniedHandler;

    public WebSecurityConfig(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .requestCache()
//                .requestCache(myRequestCache)
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(myAccessDeniedHandler);
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/main", "/","/all-sell","/all-rent","/address/**","/apartment/**").permitAll()
                .antMatchers("/add-advertisement").hasAnyRole("USER")
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        //in memory auth

        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

}

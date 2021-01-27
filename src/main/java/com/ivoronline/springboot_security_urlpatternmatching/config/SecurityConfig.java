package com.ivoronline.springboot_security_urlpatternmatching.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {

    //SPECIFY ACCESS TO ENDPOINTS
    httpSecurity.authorizeRequests()
      .antMatchers("/endPoint1").denyAll()                          //No access (even after log in)
      .antMatchers("/endPoint2").permitAll()                        //No log in (anonymous access)
      .antMatchers("/endPoint3").hasRole("ADMIN")                   //ADMIN ROLE can access AFTER log in
      .antMatchers("/Hello").hasAnyRole("ADMIN", "USER");  //ADMIN/USER ROLE can access AFTER log in

    //REDIRECT TO LOGIN FORM
    httpSecurity.formLogin();

  }

}

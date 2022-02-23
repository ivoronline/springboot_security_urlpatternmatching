package com.ivoronline.springboot_security_urlpatternmatching.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //=================================================================
  // CONFIGURE
  //=================================================================
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {

    //SELECT SPECIFIC ENDPOINTS
    httpSecurity.authorizeRequests()
      .antMatchers("/EndPoint2")             .hasRole("USER")   //Select single   Endpoint
      .antMatchers("/EndPoint3","/EndPoint4").hasRole("USER")   //Select multiple Endpoints from the list
      .antMatchers("/EndPoint5")             .hasRole("ADMIN");

    //SELECT ENDPOINTS USING URL PATTERNS
    httpSecurity.authorizeRequests()
      .antMatchers("/bikes/*").hasRole("USER")    //Second level:  /bikes/EndPoint6
      .antMatchers("/cars/**").hasRole("USER");   //Any sub-level: /cars/bmw/EndPoint7

    //AUTHENTICATE WITH DEFAULT LOGIN FORM
    httpSecurity.formLogin();                     //Without this there is no Login Form to Authenticate

  }

}



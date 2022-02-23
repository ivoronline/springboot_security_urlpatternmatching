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
      .antMatchers("/EndPoint1")             .hasRole("USER")   //Select single   Endpoint
      .antMatchers("/EndPoint2","/EndPoint3").hasRole("USER")   //Select multiple Endpoints from the list
      .antMatchers("/EndPoint4")             .hasRole("ADMIN");

    //SELECT ENDPOINTS AT ASTERISK LEVEL
    httpSecurity.authorizeRequests()
      .antMatchers("/*"              ).hasRole("USER")     //1st level Endpoint
      .antMatchers("/end*"           ).hasRole("USER")     //1st level Endpoint that starts with /end
      .antMatchers("/bikes/*"        ).hasRole("USER")     //2nd level Endpoint that starts with /bikes/
      .antMatchers("/bikes/end*"     ).hasRole("USER")     //2nd level Endpoint that starts with /bikes/end
      .antMatchers("/end*","/bikes/*").hasRole("USER");    //Endpoint that matches listed URL Patterns

    //SELECT ENDPOINTS AT ASTERISK LEVEL AND BELOW
    httpSecurity.authorizeRequests()
      .antMatchers("/**"               ).hasRole("USER")   //Any level Endpoint
      .antMatchers("/end**"            ).hasRole("USER")   //Any level Endpoint that starts with /end
      .antMatchers("/cars/**"          ).hasRole("USER")   //Any level Endpoint that starts with /cars/
      .antMatchers("/cars/end**"       ).hasRole("USER")   //Any level Endpoint that starts with /cars/end
      .antMatchers("/end**", "/cars/**").hasRole("USER");  //Endpoint that matches listed URL Patterns

    //AUTHENTICATE WITH DEFAULT LOGIN FORM
    httpSecurity.formLogin(); //Without this there is no Login Form to Authenticate

  }

}

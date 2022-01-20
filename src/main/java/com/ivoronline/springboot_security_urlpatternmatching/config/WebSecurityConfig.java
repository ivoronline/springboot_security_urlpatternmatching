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
      .antMatchers("/EndPoint1")              .hasRole("USER")  //Select single  Endpoint
      .antMatchers("/EndPoint2", "/EndPoint3").hasRole("USER"); //Select multiple Endpoints from the list

    //SELECT ENDPOINTS - USING ASTERISK '*'
    httpSecurity.authorizeRequests()
      .antMatchers("/*"                  ).hasRole("USER")      //Select Endpoints-this level
      .antMatchers("/cars/*"             ).hasRole("USER")      //Select Endpoints-this level
      .antMatchers("/cars/end*"          ).hasRole("USER")      //Select Endpoints-this level-start with /end
      .antMatchers("/cars/*", "/bikes*"  ).hasRole("USER");     //Select Endpoints that match listed URL Patterns

    //SELECT ENDPOINTS - USING DOUBLE ASTERISK '**'
    httpSecurity.authorizeRequests()
      .antMatchers("/**"                 ).hasRole("USER")      //Select Endpoints-any level
      .antMatchers("/end**"              ).hasRole("USER")      //Select Endpoints-any level-start with /end
      .antMatchers("/cars/**"            ).hasRole("USER")      //Select Endpoints-any level-start with /cars/
      .antMatchers("/cars/end**"         ).hasRole("USER")      //Select Endpoints-any level-start with this
      .antMatchers("/cars/*", "/bikes/**").hasRole("USER");     //Select Endpoints that match listed URL Patterns

    //AUTHENTICATE WITH DEFAULT LOGIN FORM
    httpSecurity.formLogin(); //Without this there is no Login Form to Authenticate

  }

}

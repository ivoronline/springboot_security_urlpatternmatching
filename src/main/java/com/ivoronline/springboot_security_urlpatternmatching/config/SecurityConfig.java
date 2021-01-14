package com.ivoronline.springboot_security_urlpatternmatching.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .authorizeRequests(authorize -> { authorize.antMatchers(HttpMethod.GET, "/end*").permitAll(); })
      .authorizeRequests().anyRequest().authenticated()
      .and().formLogin()
      .and().httpBasic();
  }

}

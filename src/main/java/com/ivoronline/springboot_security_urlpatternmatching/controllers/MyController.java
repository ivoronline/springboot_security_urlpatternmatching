package com.ivoronline.springboot_security_urlpatternmatching.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //NO ROLES ADDED
  @RequestMapping("/EndPoint1")          public String ep1() { return "Hello from EndPoint1"; }  //ANONYMOUS ACCESS

  //ROLE ADDED USING EXPLICIT NAMES
  @RequestMapping("/EndPoint2")          public String ep2() { return "Hello from EndPoint2"; }  //USER
  @RequestMapping("/EndPoint3")          public String ep3() { return "Hello from EndPoint3"; }  //USER
  @RequestMapping("/EndPoint4")          public String ep4() { return "Hello from EndPoint4"; }  //USER
  @RequestMapping("/EndPoint5")          public String ep5() { return "Hello from EndPoint5"; }  //ADMIN

  //ROLE ADDED USING URL PATTERNS
  @RequestMapping("/bikes/EndPoint6")    public String ep6() { return "Hello from EndPoint6"; }  //USER
  @RequestMapping("/cars/bmw/EndPoint7") public String ep7() { return "Hello from EndPoint7"; }  //USER

}


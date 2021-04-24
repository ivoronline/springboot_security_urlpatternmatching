package com.ivoronline.springboot_security_urlpatternmatching.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  @RequestMapping("/EndPoint1")       public String ep1() { return "Hello from EndPoint1"; }
  @RequestMapping("/EndPoint2")       public String ep2() { return "Hello from EndPoint2"; }
  @RequestMapping("/EndPoint3")       public String ep3() { return "Hello from EndPoint3"; }
  @RequestMapping("/cars/EndPoint4")  public String ep4() { return "Hello from EndPoint4"; }
  @RequestMapping("/bikes/EndPoint5") public String ep5() { return "Hello from EndPoint5"; }
}


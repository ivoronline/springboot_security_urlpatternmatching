package com.ivoronline.springboot_security_urlpatternmatching.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody @RequestMapping("/hello")              public String sayHello() { return "hello";     }
  @ResponseBody @RequestMapping("/endPoint1")          public String ep1()      { return "endPoint1"; }
  @ResponseBody @RequestMapping("/endPoint2")          public String ep2()      { return "endPoint2"; }
  @ResponseBody @RequestMapping("/endPoint3")          public String ep3()      { return "endPoint3"; }
  @ResponseBody @RequestMapping("/endPoint4")          public String ep4()      { return "endPoint4"; }
  @ResponseBody @RequestMapping("/sublevel/endPoint5") public String ep5()      { return "endPoint5"; }

  @GetMapping("/Hello")
  public String hello() {
    return "Test";
  }

}


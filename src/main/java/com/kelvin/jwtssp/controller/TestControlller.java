package com.kelvin.jwtssp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestControlller {

    @RequestMapping("/secured/test")
    @ResponseBody
    public String test(@RequestAttribute(value = "SSO_IRIS4_OPENTOKEN_COOKIE") String open_token) {
        return "success:: "+open_token;
    }

    @RequestMapping("/secured/homePage")
    public String home() {
        return "home";
    }
    @RequestMapping("/secured/hello")
    @ResponseBody
    public String hello() {
        return "secured resource";
    }

    @GetMapping("/rest/test")
    @ResponseBody
    public String test_rest() {
        return "success";
    }
}

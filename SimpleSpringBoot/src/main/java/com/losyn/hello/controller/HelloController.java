package com.losyn.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO: ����Ҫдע�͵�!
 */
@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public @ResponseBody String helloWold(){
        return "Hello Wold!!!";
    }
}

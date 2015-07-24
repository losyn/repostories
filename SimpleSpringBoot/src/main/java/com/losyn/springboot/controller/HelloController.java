package com.losyn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello Wold Controller
 */
@Controller
@RequestMapping("/demo")
public class HelloController {

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public @ResponseBody String helloWold(){
        return "Hello Wold!!!";
    }

    @RequestMapping(value ="/freemarker", method = RequestMethod.GET)
    public String freemarker(){
        return "ftl/freemarker";
    }

    @RequestMapping(value ="/velocity", method = RequestMethod.GET)
    public String velocity(){
        return "vm/velocity";
    }

    @RequestMapping(value ="/jsp", method = RequestMethod.GET)
    public String toJSP(){
        return "jsp/hello";
    }
}

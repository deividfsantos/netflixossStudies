package com.hystrixdashboardpoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("developer/v1")
public class DeveloperEndpoint {

    @RequestMapping(value="/hello",
            method= RequestMethod.GET)
    public String hello(){
        return new DeveloperController().execute();
    }

}

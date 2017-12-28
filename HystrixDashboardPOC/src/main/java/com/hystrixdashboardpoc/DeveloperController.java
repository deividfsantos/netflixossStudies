package com.hystrixdashboardpoc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeveloperController extends HystrixCommand<String> {

    public DeveloperController() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(10000)));
    }

    @Override
    protected String run() {

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {

        }
        return "Hello World";
    }

    @Override
    public String getFallback(){
        return "Hello teste";
    }

}

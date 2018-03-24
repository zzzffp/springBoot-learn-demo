package com.goku.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * Created by nbfujx on 2018/3/21.
 */
@Component
public class AsyncService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void update(int str,int da) {
        try {
            Thread.sleep(10);
            restTemplate.getForEntity("http://localhost:8091/call/"+str+"/"+da,  String.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("operation complete.");
    }

}

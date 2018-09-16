package com.example.tracerboxone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class TracerBoxService {

    @Autowired
    public RestTemplate restTemplate;

    public boolean flag = true;

    @Value("${restURL}")
    public String restURL;

    public TracerBoxService(){
    }

    public void start() {
        Random rand = new Random();
        while(flag){
            int  n = rand.nextInt(10) + 1;
            try {
                Thread.sleep(n + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String restReply = restTemplate.getForObject(restURL, String.class);
            System.out.println("Rest Reply: " + restReply);
        }
    }

    public void stop(){
        flag = false;
    }
}

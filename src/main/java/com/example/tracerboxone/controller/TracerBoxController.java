package com.example.tracerboxone.controller;

import com.example.tracerboxone.service.TracerBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TracerBoxController {

    @Autowired
    public final TracerBoxService tracerBoxService;

    public TracerBoxController() {
        tracerBoxService = null;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello from Tracer Box One!";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startApiCalls(){
        new Thread(()-> {
            tracerBoxService.start();
        }).start();
        return "API Calls Started!";
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public String stopApiCalls(){
        tracerBoxService.stop();
        return "API Calls Stopped!";
    }
}

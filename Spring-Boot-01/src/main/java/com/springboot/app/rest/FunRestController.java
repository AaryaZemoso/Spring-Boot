package com.springboot.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @PostMapping("/ping")
    public String ping2(){
        return "Yelaru Vanakam";
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pinged at : " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String workOut(){
        return "Daily Workout - run 5km";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach Name : " + coachName + " <br/>Team Name : " + teamName;
    }
}

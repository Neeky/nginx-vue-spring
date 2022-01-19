package com.sqlpy.hellospring.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class HellospringApplication {

    @RequestMapping("/current-time")
    private Map currentTime() {
        Map<String,String> map = new HashMap<>();
        Date currentTime = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("now",formater.format(currentTime));
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(HellospringApplication.class, args);
    }

}

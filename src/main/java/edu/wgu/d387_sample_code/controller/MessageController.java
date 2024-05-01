package edu.wgu.d387_sample_code.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@RestController
@RequestMapping(path = "/welcome")
public class MessageController {

    @GetMapping("/message")
    public ResponseEntity<List<String>> getMessages() {
        List<String> list = new ArrayList<>();
        Properties properties = new Properties();
        ExecutorService messageExecutor = newFixedThreadPool(2);
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                list.add(properties.getProperty("welcome"));


            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                list.add(properties.getProperty("welcome"));


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
        return ResponseEntity.ok(list);
    }



}














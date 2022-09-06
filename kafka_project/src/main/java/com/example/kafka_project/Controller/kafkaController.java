package com.example.kafka_project.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v5/kafkaController")
public class kafkaController {

    com.example.kafka_project.ABC.kafkaProducer kafkaProducer;

    public kafkaController(com.example.kafka_project.ABC.kafkaProducer kafkaProducer)

    {
        this.kafkaProducer =kafkaProducer;
    }

    //http://localhost:8085/api/v5/kafkaController/publish?message="Hello World"

    @GetMapping(path = "/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        kafkaProducer.send(message);
        return ResponseEntity.ok("Message Sent");
    }



}

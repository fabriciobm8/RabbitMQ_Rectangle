package com.example.java_rabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  @Autowired
  private Consumer consumer;

  @GetMapping("/result")
  public RectangleResult getLatestResult() {
    return consumer.getLatestResult();
  }
}

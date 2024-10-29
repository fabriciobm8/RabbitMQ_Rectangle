package com.example.java_rabbitMQ;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

  private RectangleResult latestResult; // Armazenar apenas o último resultado
  private final ObjectMapper objectMapper = new ObjectMapper();

  @RabbitListener(queues = JavaRabbitMQConfig.QUEUE_NAME)
  public void receiveMessage(String message) {
    try {
      // Converter a mensagem JSON em um objeto
      JsonNode jsonNode = objectMapper.readTree(message);
      double base = jsonNode.get("base").asDouble();
      double altura = jsonNode.get("altura").asDouble();

      // Calcular área e perímetro
      double area = base * altura;
      double perimetro = 2 * (base + altura);

      // Criar um novo resultado e armazenar
      latestResult = new RectangleResult(base, altura, area, perimetro);
      System.out.println(" [x] Calculated: " + latestResult);
    } catch (IOException e) {
      System.err.println("Erro ao processar mensagem: " + e.getMessage());
    }
  }

  public RectangleResult getLatestResult() {
    return latestResult;
  }
}

package com.bosch.probe.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

  @Autowired
  private FirstConsumer firstConsumer;

  @Override
  public void run(String... args) throws Exception {
    String command = args.length >= 1 ? args[0] : "help";
    String param = args.length >= 2 ? args[1] : null;
    logger.info("COMMAND LINE RUNNER cmd={}, param={}", command, param);

    switch (command){
      case "add": firstConsumer.add(param);
        break;
      case "get": firstConsumer.get(param);
        break;
      default:logger.info("use 'add' or 'get' command");

    }
  }

}

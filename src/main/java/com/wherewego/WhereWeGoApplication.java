package com.wherewego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WhereWeGoApplication {

  public static void main(String[] args) {
    SpringApplication.run(WhereWeGoApplication.class, args);
  }
}


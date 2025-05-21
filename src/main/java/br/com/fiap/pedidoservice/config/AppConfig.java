package br.com.fiap.pedidoservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

package br.com.tt.petshopweb.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WelcomeService {

    public WelcomeService() {
        System.out.println("WelcomeService INICIADO!");
    }

    public  String obtemVersao() {
       return String.format("v1.0.0 - %s", LocalDateTime.now().toString());
   }
}

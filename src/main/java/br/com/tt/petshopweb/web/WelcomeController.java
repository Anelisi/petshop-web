package br.com.tt.petshopweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping
    public String ola(Model model) {
        List<String> notas = Arrays.asList(
                "Criado Controller Welcome",
                "Criada página inicial",
                "Usado o Thymeleaf");

        model.addAttribute("notas" , notas);
       // model.addAttribute("versao","v1.0.0 =>" + LocalDateTime.now().toString());

        return "welcome-page";
    }

}

package br.com.tt.petshopweb.web;

import br.com.tt.petshopweb.model.Unidade;
import br.com.tt.petshopweb.service.UnidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UnidadeController {

    String redirect = "redirect:/admin/unidades";

    @Autowired
    private UnidadeService service;

    @GetMapping("/admin/unidades")
    public String listar(Model model) {
        List<Unidade> unidades = service.listar();
        model.addAttribute("unidades", unidades);
        return "unidades-page";
    }

    private final static Logger LOG = LoggerFactory.getLogger(UnidadeController.class);

    @PostMapping("/actions/criar-unidade")
    public String criar(Unidade unidadeCriacao, RedirectAttributes attributes) {
        try {
            service.criar(unidadeCriacao);
            attributes.addAttribute("mensage","Unidade criada com sucesso!");
        } catch (Exception e) {
            tratarErro(attributes, e);
        }

        return redirect;
    }

    @PostMapping("/actions/atualizar-unidade")
    public String atualizar(Unidade unidade, RedirectAttributes attributes) {
        try {
            service.atualizar(unidade);
            attributes.addAttribute("mensage","Unidade atualizada com sucesso!");
        } catch (Exception e) {
            tratarErro(attributes, e);
        }
        return redirect;
    }

    private void tratarErro(RedirectAttributes attributes, Exception e) {
        LOG.error("Ocorreu um erro", e);
        String erro = String.format("Ocorreu um erro: %s", e.getMessage());
        attributes.addFlashAttribute("erro", erro);
    }
}

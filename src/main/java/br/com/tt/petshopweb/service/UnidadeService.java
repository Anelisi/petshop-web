package br.com.tt.petshopweb.service;

import br.com.tt.petshopweb.exception.RegraDeNegocioVioladaExceptions;
import br.com.tt.petshopweb.model.Unidade;
import br.com.tt.petshopweb.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository repository;

    public List<Unidade> listar() {
        return repository.listar();
    }

    public void criar(Unidade unidade) {
        validarTamanhoNome(unidade.getNome());
        repository.criar(unidade);

    }

    public void atualizar(Unidade unidade) {
        validarTamanhoNome(unidade.getNome());
        repository.atualizar(unidade);
    }

    private void validarTamanhoNome(String nome) {
        if (nome.length() <= 3) {
            throw new RegraDeNegocioVioladaExceptions("O nome da unidade deve conter no mínimo 3 caracteres!");
        }
    }
}

package br.com.alura.linguagens.api;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;
    
    @GetMapping(value="/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }
    
    
}

package br.com.alura.linguagemapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagem(){
        List<Linguagem> linguagens = repository.findAll(Sort.by(Sort.Direction.ASC, "ranking"));
        return linguagens;
    }

    @GetMapping("/linguagens/{id}")
    public ResponseEntity<Linguagem> obterLinguagemEspecifica(@PathVariable(value = "id") String id){
        Optional<Linguagem> linguagem = repository.findById(id);
        
        if(linguagem.isPresent()){
            return new ResponseEntity<Linguagem>(linguagem.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/linguagens")
    @ResponseStatus(HttpStatus.CREATED)
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repository.save(linguagem);
        return linguagemSalva;

    }

    @PutMapping("/linguagens/{id}")
    public ResponseEntity<Linguagem> editarLinguagem(@PathVariable(value = "id") String id, @RequestBody Linguagem linguagemNova){
        Optional<Linguagem> linguagemAntiga = repository.findById(id);

        if(linguagemAntiga.isPresent()){
            Linguagem linguagem = linguagemAntiga.get();
            linguagem.setTitle(linguagemNova.getTitle());
            linguagem.setImage(linguagemNova.getImage());
            linguagem.setRanking(linguagemNova.getRanking());
            repository.save(linguagem);
            return new ResponseEntity<Linguagem>(linguagem, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @PatchMapping("/linguagens/{id}")
    public ResponseEntity<Linguagem> editarLinguagemParcial(@PathVariable(value = "id") String id, @RequestBody Linguagem linguagemNova){
        Optional<Linguagem> linguagemAntiga = repository.findById(id);

        if(linguagemAntiga.isPresent()){
            Linguagem linguagem = linguagemAntiga.get();
            String newTitle = linguagemNova.getTitle();
            String newImage = linguagemNova.getImage();
            String newRanking = linguagemNova.getRanking();
        
            if(newTitle != null){
                linguagem.setTitle(newTitle);
            }
            if(newImage != null){
                linguagem.setImage(linguagemNova.getImage());
            }
            if(newRanking != null){
                linguagem.setRanking(linguagemNova.getRanking());
            }            
            
            repository.save(linguagem);
            return new ResponseEntity<Linguagem>(linguagem, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }




    @DeleteMapping("/linguagens/{id}")
    public ResponseEntity<Object> deletarLinguagem(@PathVariable(value = "id") String id){
        Optional<Linguagem> linguagem = repository.findById(id);
        
        if(linguagem.isPresent()){
            repository.delete(linguagem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    }



}

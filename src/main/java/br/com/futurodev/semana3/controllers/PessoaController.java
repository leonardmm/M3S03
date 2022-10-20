package br.com.futurodev.semana3.controllers;

import br.com.futurodev.semana3.model.Pessoa;
import br.com.futurodev.semana3.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        Pessoa pessoa1 = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(pessoa1, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {
        Pessoa pessoa1 = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(pessoa1, HttpStatus.OK
        );
    }
    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Pessoa deletada com sucesso!", HttpStatus.OK);

    }
    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable(value = "idPessoa") Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }
    @GetMapping(value = "/procuraNome/{pessoa}", produces =  "application/json")
    public ResponseEntity<List<Pessoa>> GetPessoaById(@PathVariable(name = "pessoa") String nome){
       List<Pessoa> pessoas = pessoaRepository.getPessoaByName(nome);
       return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
    }
}

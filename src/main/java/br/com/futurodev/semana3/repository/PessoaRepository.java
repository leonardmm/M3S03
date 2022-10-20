package br.com.futurodev.semana3.repository;

import br.com.futurodev.semana3.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "select c from Pessoa c where c.nome like %?1%")
    ArrayList<Pessoa> getPessoaByName(String nome);
}

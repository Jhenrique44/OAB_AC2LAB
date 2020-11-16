package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EscolaDTO;
import com.example.demo.model.Escola;
import com.example.demo.repositorio.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository repository;

    public Escola fromDTO(EscolaDTO dto){

        Escola escola = new Escola();
        escola.setNomeEscola(dto.getNomeEscola());
        escola.setTelefone(dto.getTelefone());

        return escola;
    }

    public List<Escola> getALLEscolas(){
        return repository.getALLEscolas();
    }
    public void removeByCodigo(int codigo){
        repository.remove(getEscolaByCodigo(codigo));
    }
    public Escola update(Escola escola){
        getEscolaByCodigo(escola.getCodigoEscola());
        return repository.update(escola);
    }
    public Escola getEscolaByCodigo(int codigo){
    Optional<Escola> op = repository.getEscolaByCodigo(codigo);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Escola nao cadastrada"));
    }
    public Escola save(Escola escola){
        return repository.save(escola);
    }
}

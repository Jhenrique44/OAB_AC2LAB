package com.example.demo.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.demo.model.Escola;

import org.springframework.stereotype.Component;

@Component

public class EscolaRepository {
    private List<Escola> escolas;
    private int nextCode;
    
@PostConstruct
public void criarEscola(){

    Escola c1 = new Escola();
    Escola c2 = new Escola();
    Escola c3 = new Escola();

    c1.setCodigoEscola(1);
    c1.setNomeEscola("Abraão");
    c1.setEndereço("Rua X, 99");
    c1.setCep("190");
    c1.setTelefone("9393-2033");
    
    c2.setCodigoEscola(2);
    c2.setNomeEscola("Tamandua");
    c2.setEndereço("Rua y, 00000");
    c2.setCep("0000000");
    c2.setTelefone("0000-1111");

    c3.setCodigoEscola(3);
    c3.setNomeEscola("santo antonio");
    c3.setEndereço("Rua z, 99233");
    c3.setCep("190554");
    c3.setTelefone("9393-0000");

    escolas = new ArrayList<Escola>();
    escolas.add(c1);
    escolas.add(c2);
    escolas.add(c3);
    
    nextCode = 4;
}



    public List<Escola> getALLEscolas(){
        return escolas;
    }  
    public Optional<Escola> getEscolaByCodigo(int codigo){
        for(Escola aux : escolas){
            if(aux.getCodigoEscola() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola  save(Escola escola){
        escola.setCodigoEscola(nextCode++);
        escolas.add(escola);
        return escola;

    }

    public void remove(Escola escola){
        escolas.remove(escola);
    }

    public Escola update(Escola escola){

        Escola aux = getEscolaByCodigo(escola.getCodigoEscola()).get();

        if(aux != null){
            
            //aux.setCodigoEscola(escola.getCodigoEscola());
            //aux.setNomeEscola(escola.getNomeEscola());
            aux.setEndereço(escola.getEndereço());
            aux.setTelefone(escola.getTelefone());
        }
        return aux;
    }
}

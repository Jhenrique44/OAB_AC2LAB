package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.CursoDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Escola;
import com.example.demo.repositorio.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;
    
    @Autowired 
    private EscolaService escolaService;

    public List<Curso> getALLCursos(){              ///listar todos os cursos cadastrados
        return repository.getALLCursos();
    }
    public void removeByNumero(long numero) {        ///remover um curso
        repository.remove(getCursoByNumero(numero));
    }
    
    public Curso getCursoByNumero(long numero){
        Optional<Curso> op = repository.getCursoByNumero(numero);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso não cadastrado"));
    }

    public Curso salvar(Curso curso, int idEscola){

        Escola escola = escolaService.getEscolaByCodigo(idEscola);

        curso.setEscola(escola);
        escola.addCurso(curso);

        return repository.salvar(curso);
    }

    public CursoDTO toDTO(Curso curso){

        CursoDTO dto = new CursoDTO();

        dto.setPreco(curso.getPreco());;
        return dto;
    }
    public Curso update(Curso curso) {
        getCursoByNumero(curso.getCodigoCurso());
        return repository.update(curso);
}

    public List<CursoDTO> toListDTO(List<Curso>cursos){
        ArrayList<CursoDTO> listDTO =  new ArrayList<CursoDTO>();

        for(Curso p: cursos){
            listDTO.add(toDTO(p));
        }
        return listDTO;
    }
    public Curso fromDTO(CursoDTO dto){
        Curso curso = new Curso();
        curso.setPreco(dto.getPreco());
        return curso;
    }

}

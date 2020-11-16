package com.example.demo.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.demo.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {

    private ArrayList<Curso> cursos =  new ArrayList<Curso>();
    private static int nextCodigo = 1;

    @PostConstruct
    public void criarCurso(){
        Curso g1 =  new Curso();
        g1.setCargaHoraria(1000);
        g1.setCodigoCurso(nextCodigo++);
        g1.setPreco(2300);
        g1.setNomeCurso("engenharia eletrica");
        g1.setTipoModalidade("bacharel");

        cursos.add(g1);
    }

    public List<Curso> getALLCursos(){
        return cursos;
    }

    public Optional<Curso> getCursoByNumero(long numero){
        for(Curso aux : cursos){
            if(aux.getCodigoCurso()== numero){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Curso salvar(Curso curso){
        curso.setCodigoCurso(nextCodigo++);
        cursos.add(curso);
        return curso;

    }

    public void remove(Curso curso){
        cursos.remove(curso);
    }

    public Curso update(Curso curso){

        Curso aux = getCursoByNumero(curso.getCodigoCurso()).get();

        if(aux != null){
            aux.setCargaHoraria(curso.getCargaHoraria());
            //aux.setNomeCurso(curso.getNomeCurso());
            aux.setPreco(curso.getPreco());
            //aux.setTipoModalidade(curso.getTipoModalidade());
        }
        return aux;
    }
}

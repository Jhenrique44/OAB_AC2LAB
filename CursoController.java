package com.example.demo.controller;

import java.util.List;

//import com.example.demo.dto.CursoDTO;

//import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Curso;
//import com.example.demo.model.Escola;
//import com.example.demo.repositorio.CursoRepository;
import com.example.demo.service.CursoService;
//import com.example.demo.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    

    @GetMapping         ///mostrar todos os cursos cadastrados
    public List<Curso> getALLCursos(){
        return cursoService.getALLCursos();
    }

    @GetMapping("/{numero}")         ///mostrar cursos por codigo
    public ResponseEntity<Curso> getCursoByCodigo(@PathVariable long numero){

        Curso curso = cursoService.getCursoByNumero(numero);

        return ResponseEntity.ok(curso);
    }
    
    @DeleteMapping("/{numero}")                 ///remover um curso pelo codigo
    public ResponseEntity<Void> remover(@PathVariable long numero){
        cursoService.removeByNumero(numero);
        return ResponseEntity.noContent().build();
    }
    

    /*@PutMapping("/{codigo}")
    public ResponseEntity<Curso> update(@RequestBody CursoDTO cursoDTO, @PathVariable int codigo){

        Curso curso = cursoService.fromDTO(cursoDTO);
        curso.setCodigoCurso(codigo);
        curso = cursoService.update(curso);
        return ResponseEntity.ok(curso);
        
    }*/
  
    

}

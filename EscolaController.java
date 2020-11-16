package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.CursoDTO;
import com.example.demo.dto.EscolaDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Escola;
import com.example.demo.service.CursoService;
import com.example.demo.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @Autowired 
    private CursoService cursoService;
    
    @GetMapping()                     //mostrando toda a lista de escolas 
    public List<Escola> getEscolas(){
        return escolaService.getALLEscolas();
    }

    @GetMapping("/{codigo}")        //mostrando escola por codigo
    public ResponseEntity<Escola> getEscolaByCodigo(@PathVariable int codigo){

        Escola escola = escolaService.getEscolaByCodigo(codigo);

        return ResponseEntity.ok(escola);
    }

    @PutMapping("/{codigo}") //alterar escola pelo codigo 
    public ResponseEntity<Escola> update(@RequestBody EscolaDTO escolaDTO, @PathVariable int codigo){
        
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigoEscola(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);       //retorna 200=ok
    } 

    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remove(@PathVariable int codigo){
        
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{idEscola}/cursos")        //cadastra um curso associado a uma escola
    public ResponseEntity<Curso> salvar(@PathVariable int idEscola, @RequestBody Curso curso,
        HttpServletRequest request, UriComponentsBuilder builder    
    ){
        curso = cursoService.salvar(curso, idEscola);
        UriComponents uriComponents = builder.path(request.getRequestURI()+ "/" + curso.getCodigoCurso()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{idEscolas}/cursos")      //mostra os cursos linkados a uma escola 
    public List<CursoDTO> getCursosEscola(@PathVariable int idEscola){
        Escola escola = escolaService.getEscolaByCodigo(idEscola);
        return cursoService.toListDTO(escola.getCursos());
    }
    @PostMapping()
    public ResponseEntity<Escola> salvar( @RequestBody EscolaDTO escolaDTO, HttpServletRequest request,
            UriComponentsBuilder builder

    ) {

        Escola escola = escolaService.fromDTO(escolaDTO);
        Escola novaEscola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novaEscola.getCodigoEscola()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    
}

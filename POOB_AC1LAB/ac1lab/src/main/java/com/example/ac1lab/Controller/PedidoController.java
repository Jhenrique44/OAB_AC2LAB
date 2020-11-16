package com.example.ac1lab.Controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ac1lab.Model.Pedido;
import com.example.ac1lab.Repositorio.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedidos")

public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @GetMapping // comando GET do HTTPS para pegar todos os pedidos
    public List<Pedido> getPedidos(){
        return repository.getALLPedidos();
    }

    @GetMapping("/{codigo}") // para comendo GET do HTTPS
    public ResponseEntity<Pedido> getPedido(@PathVariable int codigo){

        Pedido pedido = repository.getPedidoCodigo(codigo);

        //if para saber se existe um pedido com o id passado 
        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping //comando POST do HTTPS para salvar
    public ResponseEntity<Void> salvar(@RequestBody Pedido pedido){
        Pedido ped = repository.salvar(pedido);
        pedido.setDatapedido(LocalDateTime.now());
        URI uri = URI.create("https://localhost:8080/pedidos/" + ped.getCodigo());
        return ResponseEntity.created(uri).build(); //retorna 201 = sucesso em salvar um novo recurso
    }

    @PutMapping("/{codigo}")// para comando PUT do HTTPS
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido, @PathVariable int codigo){
        if (repository.getPedidoCodigo(codigo) != null) {
            pedido.setCodigo(codigo);
            pedido = repository.altera(pedido); 
            if(pedido != null){
                return ResponseEntity.ok(pedido); //retorna 200 = ok
             }
        }
        return ResponseEntity.notFound().build(); //retorna 404 = not found
    }

    @DeleteMapping("{codigo}") // para comando DEL do HTTPS
    public ResponseEntity<Void> remove(@PathVariable int codigo){ //recebe o codigo do pedido para deletar 
        Pedido ped = repository.getPedidoCodigo(codigo);
        if (ped != null) {
            repository.remove(ped);
            return ResponseEntity.noContent().build(); // return 204 = no content 
        } else {
            return ResponseEntity.notFound().build(); //return 404 = not found 
        }
    }
}
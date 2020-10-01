package com.example.ac1lab.Repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.print.event.PrintServiceAttributeListener;

import com.example.ac1lab.Model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    private List<Pedido> pedidos;
    private int code = 0;

    @PostConstruct
    public void criarPedidos(){
        //teste do servidor
        Pedido p1 =  new Pedido();
        p1.setCliente("joão");
        p1.setCodigo(code++);
        p1.setDescricao("Sabão");
        p1.setValor(50);
        p1.setDatapedido("10-09-2020");

        pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
    }   
    //permite pegar todos os pedidos na lista
    public List<Pedido> getALLPedidos(){

        return pedidos;
    }
    //permite pegar um pedido pelo codigo dele
    public Pedido getPedidoCodigo(int codigo){

        for(Pedido aux : pedidos){

            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }
    //Cadastrar um pedido na lista
    public Pedido salvar(Pedido pedido){

        pedido.setCodigo(code++);
        pedidos.add(pedido);
        return pedido;

    }
    //altera o conteudo do pedido 
    public Pedido altera(Pedido pedido){

        Pedido aux = getPedidoCodigo(pedido.getCodigo());

        if (aux !=  null) { 

            aux.setCliente(pedido.getCliente());
            aux.setDescricao(pedido.getDescricao());
            aux.setValor(pedido.getValor());
            aux.setDatapedido(pedido.getDatapedido());
        
        }
        return aux;
            
    }
    public void remove(Pedido pedido){

        pedidos.remove(pedido);

    }
}


package com.example.demo.model;

public class Curso {
    
    private long codigoCurso;
    private String nomeCurso;
    private double cargaHoraria;
    private double preco;
    private String tipoModalidade; //bacharel, tecnologo e presencial ou a distancia
    private Escola escola;

    public Curso(){
        
    }
    public Curso(long codigoCurso){
        this.codigoCurso = codigoCurso;
    }

    public long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoModalidade() {
        return tipoModalidade;
    }

    public void setTipoModalidade(String tipoModalidade) {
        this.tipoModalidade = tipoModalidade;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Curso [cargaHoraria=" + cargaHoraria + ", codigoCurso=" + codigoCurso + ", escola=" + escola
                + ", nomeCurso=" + nomeCurso + ", preço=" + preco + ", tipoModalidade=" + tipoModalidade + "]";
    }


    
}

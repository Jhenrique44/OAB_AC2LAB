package com.example.demo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Escola {
    
    private int codigoEscola;
    private String nomeEscola;
    private String endereço;
    private String telefone;
    private String cep;
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    @JsonIgnore
    

    public int getCodigoEscola() {
        return codigoEscola;
    }

    public void setCodigoEscola(int codigoEscola) {
        this.codigoEscola = codigoEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public ArrayList<Curso> getCursos(){
        return cursos;
    }

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
    }

    public boolean addCurso(Curso curso){
        return cursos.add(curso);
    }
    public boolean removeCurso(Curso curso){
        return cursos.remove(curso);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

	@Override
	public String toString() {
		return "Escola [cep=" + cep + ", codigoEscola=" + codigoEscola + ", cursos=" + cursos + ", endereço=" + endereço
				+ ", nomeEscola=" + nomeEscola + ", telefone=" + telefone + "]";
	}
    

}

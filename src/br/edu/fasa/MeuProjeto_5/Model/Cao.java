/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto_5.Model;

/**
 *
 * @author paulocesar
 */
public class Cao {
    
    private int cod;   
    private String Nome;
    private String raca;
    private String cor;
    private float peso;
    private int idade;
    private String latido;
    
    
    public Cao(){
       this.cod = 0; 
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLatido() {
        return latido;
    }

    public void setLatido(String latido) {
        this.latido = latido;
    }   
    
     public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
}

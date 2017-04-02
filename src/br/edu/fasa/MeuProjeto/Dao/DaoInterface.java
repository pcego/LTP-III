/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Dao;

import java.util.ArrayList;


// interface são um espécie de contrato
// que contém métodos apenas com assinatura
// para serem implementados pelas classes que a utilizarem
// T representa a api genérics do java
public interface DaoInterface <T> {
    
    public boolean inserir(T obj);
    public ArrayList<T> listaTodos();    
    public int atualizar(T obj);
    public int apagar(T obj);
    
}

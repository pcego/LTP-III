/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Dao;

import java.util.ArrayList;

/**
 *
 * @author paulocesar
 */
public interface DaoInterface <T> {
    
    public boolean inserir(T obj);
    public ArrayList<T> listaTodos();    
    public int atualizar(T obj);
    public int apagar(T obj);
    
}

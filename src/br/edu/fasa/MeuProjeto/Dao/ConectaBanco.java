/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sun.management.GarbageCollectionNotifInfoCompositeData;

// Classe contendo dados referentes a conexão com bd
public class ConectaBanco {
    
    private static Connection conexao = null;
    
    // constante com a url padrão para conexão ao banco de dados; neste caso postgres
    // rodando localmente
    private static final String URL = "jdbc:postgresql://localhost:5432/petshop";
    
    // constante com o usuário cadastrado do bd
    private static final String USER = "postgres";
    
    // constante com a senha de acesso ao bd
    private static final String PWD = "senha";

    // construtor da classe encapsulado
    private ConectaBanco() {

    }

    
    // método para gerenciamento de conexões ao bd    
    public static Connection getConexao() {

        if (conexao == null) {

            try {
                conexao = DriverManager.getConnection(URL, USER, PWD);

            } catch (SQLException sqlex) {
                JOptionPane.showMessageDialog(null,
                        sqlex.getMessage(), "Erro na conexão com o banco de dados",
                        JOptionPane.ERROR_MESSAGE);
            }           
                        
        }
        return conexao;

    }

}

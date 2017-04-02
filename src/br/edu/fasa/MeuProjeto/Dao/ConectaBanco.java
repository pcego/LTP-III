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

/**
 *
 * @author paulocesar
 */
public class ConectaBanco {

    private static Connection conexao = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/petshop";
    private static final String USER = "postgres";
    private static final String PWD = "senha";

    private ConectaBanco() {

    }

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

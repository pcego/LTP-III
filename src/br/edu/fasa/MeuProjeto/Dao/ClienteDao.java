/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Dao;

import br.edu.fasa.MeuProjeto_5.Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author pcego
 */
public class ClienteDao implements DaoInterface<Cliente> {

    @Override
    public boolean inserir(Cliente obj) {
        
        /*
        Início do bloco de código que pode apresentar
        uma possível exceção.
        */
        try {
            // Intanciando uma um objeto da Classe Connection
            // através do método getConexão presente na classe ConectaBanco
            Connection con = ConectaBanco.getConexao();
            
            // Variável para receber uma query para execução
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("insert into clientes "
                    + "(nome, rua, numero, bairro, cidade, telefone, celular, data_cadastro) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?);");
            
            // Atribuindo valores às interrogações presentes 
            // na query
            
            LocalDate data_cadastro = LocalDate.now();
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getRua());
            pstmt.setInt(3, obj.getNumero());
            pstmt.setString(4, obj.getBairro());
            pstmt.setString(5, obj.getCidade());
            pstmt.setString(6, obj.getTelefone());
            pstmt.setString(7, obj.getCelular());
            pstmt.setDate(8, Date.valueOf(data_cadastro));
            
            // chamada ao método para execução da query
            // este método retorna 1 caso a query seja executada com sucesso
            // e dois caso aconteça um erro
            pstmt.executeUpdate();
            
          // captura de exceções do tipo SQLException caso ocorram 
        } catch (SQLException sqle) {  
            System.out.println(sqle.getMessage());
            return false;           
            
        }
        
        // Captura de qualquer exceção que ocorra durante a execução
        // do bloco de código
        catch(Exception ex){
            
            // Imprime toda pilha de chamadas de métodos
            // até o ponto onde ocorreu a exceção
            ex.printStackTrace();
            return false;
        }         
        
        return true;
        
    }

    @Override
    public ArrayList<Cliente> listaTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int atualizar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int apagar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

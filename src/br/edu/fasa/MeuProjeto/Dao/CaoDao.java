/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Dao;

import br.edu.fasa.MeuProjeto_5.Model.Cao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Classe utilizada para manipulação de dados dos objetos
Cao. Esta classe implementa DaoInterface que possui a 
assinatura dos métodos a serem implementados: inserir,
listaTodos, listaPorNome,atualizar, apagar.

Obs: Estudar interfaces e genérics
*/
public class CaoDao implements DaoInterface<Cao> {
    
    
    /* Método inserir subscrito (@Override)
    recebe como parâmetro um objeto Cao e retorna 
    um valor boolean (true ou false)    
    */
    @Override
    public boolean inserir(Cao obj) {

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
            pstmt = con.prepareStatement("insert into cachorros "
                    + "(nome, raca, cor, peso, idade, latido) "
                    + "values(?, ?, ?, ?, ?, ?);");
            
            // Atribuindo valores às interrogações presentes 
            // na query
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getRaca());
            pstmt.setString(3, obj.getCor());
            pstmt.setFloat(4, obj.getPeso());
            pstmt.setInt(5, obj.getIdade());
            pstmt.setString(6, obj.getLatido());
            
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

    // método para listar todos os dados presentes na tabela cachorros
    // Retorna um Array de objetos do tipo Cao
    @Override
    public ArrayList<Cao> listaTodos() {
        
        // Instanciando um ArrayList de objetos Cao
        ArrayList<Cao> caes = new ArrayList<Cao>();

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            // select preparada para execução
            pstmt = con.prepareStatement("select *from cachorros");
            
            // chamada ao método executeQuery
            // este método executa a query presente na variável pstmt
            // retornando um Resultset que contém todos os dados solicitados
            // na query.
            ResultSet rs = pstmt.executeQuery();              
            
            // loop para iterar sobre o ResultSet que contém os
            // dados da query. O método next() posiciona o ponteiro
            // no primeiro resultado encontrado e a cada iteração do loop
            // ele aponta para o próximo resultado até não existirem mais 
            // resultados retornando false ao final permitindo sair do loop
            while(rs.next()){
                
                // instanciando um objeto do tipo Cao
                Cao c = new Cao();
                
                // atribuindo os valores recebidos no ResultSet
                // ao objeto Cao. Os métodos get do objeto rs recuperam
                // os valores através das chaves, que na verdade são
                // os nomes das referidas colunas no banco de dados.                
                c.setCod(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setRaca(rs.getString("raca"));
                c.setCor(rs.getString("cor"));
                c.setPeso(rs.getFloat("peso"));
                c.setIdade(rs.getInt("idade"));
                c.setLatido(rs.getString("latido"));
                
                // adicionando cada objeto recebido ao ArrayList
                // através do método add()
                caes.add(c);                               
            }      
             

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
        }

        return caes;
    }
    
    
    @Override
    public int atualizar(Cao obj) {
        int aux = 0;
        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            // string contendo a sql para realizar update na tabela cachorros
            String sql = "update cachorros set nome = ?, raca = ?, cor= ?, "
                    + "peso = ?, idade = ?, latido = ? where id = ?;";
            
            
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getRaca());
            pstmt.setString(3, obj.getCor());
            pstmt.setFloat(4, obj.getPeso());
            pstmt.setInt(5, obj.getIdade());
            pstmt.setString(6, obj.getLatido());
            pstmt.setInt(7, obj.getCod());
            
            // variável aux recebe o retorno da execução do método
            // executeUpdate()
            aux = pstmt.executeUpdate();         

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());           
            return aux;            
        }
        return aux;
    }

    @Override
    public int apagar(Cao obj) {
        
        int aux = 0;
        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            String sql = "delete from cachorros where id=?;";
            pstmt = con.prepareStatement(sql);           
                     
            pstmt.setInt(1, obj.getCod());
            
            aux = pstmt.executeUpdate();         

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            
        }
        return aux;
    }

    public ArrayList<Cao> listaPorNome(String nome) {
        ArrayList<Cao> caes = new ArrayList<Cao>();

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("select *from cachorros where nome=? order by nome;");
            pstmt.setString(1, nome);            
            
            ResultSet rs = pstmt.executeQuery();              
            
                                               
            while(rs.next()){
                Cao c = new Cao();
                c.setCod(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setRaca(rs.getString("raca"));
                c.setCor(rs.getString("cor"));
                c.setPeso(rs.getFloat("peso"));
                c.setIdade(rs.getInt("idade"));
                c.setLatido(rs.getString("latido"));
                
                caes.add(c);                               
            }      
             

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
        }

        return caes;
    }

}

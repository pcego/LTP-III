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

/**
 *
 * @author paulocesar
 */
public class CaoDao implements DaoInterface<Cao> {
    
    @Override
    public boolean inserir(Cao obj) {

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("insert into cachorros "
                    + "(nome, raca, cor, peso, idade, latido) "
                    + "values(?, ?, ?, ?, ?, ?);");

            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getRaca());
            pstmt.setString(3, obj.getCor());
            pstmt.setFloat(4, obj.getPeso());
            pstmt.setInt(5, obj.getIdade());
            pstmt.setString(6, obj.getLatido());

            pstmt.executeUpdate();
            

        } catch (SQLException sqle) {  
            System.out.println(sqle.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<Cao> listaTodos() {
        ArrayList<Cao> caes = new ArrayList<Cao>();

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("select *from cachorros");
            
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

    @Override
    public int atualizar(Cao obj) {
        int aux = 0;
        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            String sql = "update cachorros set nome = ?, raca = ?, cor= ?, peso = ?, idade = ?, latido = ? where id = ?;";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getRaca());
            pstmt.setString(3, obj.getCor());
            pstmt.setFloat(4, obj.getPeso());
            pstmt.setInt(5, obj.getIdade());
            pstmt.setString(6, obj.getLatido());
            pstmt.setInt(7, obj.getCod());
            
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

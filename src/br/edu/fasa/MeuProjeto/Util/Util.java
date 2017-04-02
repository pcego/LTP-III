/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Util;

import br.edu.fasa.MeuProjeto.Dao.ConectaBanco;
import br.edu.fasa.MeuProjeto_5.Gui.TelaConsulta;
import br.edu.fasa.MeuProjeto_5.Gui.TelaCadCachorro;
import br.edu.fasa.MeuProjeto_5.Gui.TelaCadCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Classe com métodos para instaciar janelas
// e capturar ultimo código inserido 
public class Util {
    
    public static TelaCadCachorro tp = null;
    public static TelaConsulta tc = null;
    public static TelaCadCliente tcCliente = null;
    
    public static int getUltimoCodigo(String nomeTabela) {
        
        int ultimoCodigo = 0;

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt = null;
            // select para acessar ultimo id inserido no bd postgres
            pstmt = con.prepareStatement("select MAX(id) from " + nomeTabela +";");            

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ultimoCodigo = rs.getInt(1);
            }            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
        
        return ultimoCodigo;
    }   
    
    // método para instanciar objetos do tipo TelaCadCachorro
    // caso já exista um objeto em memória o mesmo é retornado
    // caso contrário o mesmo é instanciado e retornado
    public static TelaCadCachorro getCadCachorro(){        
        
        if(tp == null){
           tp = new TelaCadCachorro();
        }
        return tp;
    }
    
    // idem ao anterior
    public static TelaConsulta getConsulta(){
        if(tc == null){
            tc = new TelaConsulta();
        }
        return tc;
    }
    
    public static TelaCadCliente getCadCliente(){
        if(tcCliente == null){
            tcCliente = new TelaCadCliente();
        }
        return tcCliente;
    }
}

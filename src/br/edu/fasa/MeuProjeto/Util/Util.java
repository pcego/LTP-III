/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.MeuProjeto.Util;

import br.edu.fasa.MeuProjeto.Dao.ConectaBanco;
import br.edu.fasa.MeuProjeto_5.Gui.TelaConsulta;
import br.edu.fasa.MeuProjeto_5.Gui.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author paulocesar
 */
public class Util {
    
    public static TelaPrincipal tp = null;
    public static TelaConsulta tc = null;
    
    public static int getUltimoCodigo() {
        
        int ultimoCodigo = 0;

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("select MAX(id) from cachorros;");

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ultimoCodigo = rs.getInt(1);
            }            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }         
        
        return ultimoCodigo;
    }   
    
    public static TelaPrincipal getPrincipal(){        
        
        if(tp == null){
           tp = new TelaPrincipal();
        }
        return tp;
    }
    
    public static TelaConsulta getConsulta(){
        if(tc == null){
            tc = new TelaConsulta();
        }
        return tc;
    }
}

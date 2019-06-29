/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Hospede;
import model.bean.SalaoFesta;

/**
 *
 * @author rene_
 */
public class SaloesDAO {
    
   public List<SalaoFesta> listar() {
        List<SalaoFesta> Saloes = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM saloes where disponibilidade = 'Disponível' ");

            rs = stmt.executeQuery();

            while (rs.next()) {
                SalaoFesta h = new SalaoFesta();
                h.setId(rs.getInt("id"));
                h.setDisponibilidade(rs.getString("disponibilidade"));
                h.setHorario(rs.getString("horarios"));
                h.setPreco(rs.getFloat("preco"));
              
                Saloes.add(h);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Saloes;

    }
   
   public void alugar_salao(SalaoFesta s) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update saloes set disponibilidade = ? where id = ?");
            
            stmt.setString(1,s.getDisponibilidade());
            stmt.setInt(2, s.getId());
            
            int add = stmt.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null, "Horário marcado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Gerente;
import model.bean.Hospede;

/**
 *
 * @author rene_
 */
public class GerenteDAO {
    
     public void salvar(Gerente g){
        
        Connection con  = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tabelaClientes (nome, email, cpf, endereco, telefone,login, senha,perfil)values(?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, g.getNome());
            stmt.setString(2, g.getEmail());
            stmt.setString(3, g.getCpf());
            stmt.setString(4, g.getEndereco());
            stmt.setString(5, g.getTelefone());
            stmt.setString(6, g.getLogin());
            stmt.setString(7, g.getSenha());
            stmt.setString(8, g.getPerfil());
           
            
           int adicionado = stmt.executeUpdate();
           
           if(adicionado>0){
               JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
           }
               
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}

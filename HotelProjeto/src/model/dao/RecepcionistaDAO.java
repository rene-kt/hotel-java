/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.ConnectionFactory;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Recepcionista;

/**
 *
 * @author rene_
 */
public class RecepcionistaDAO {

    public void salvar(Recepcionista r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into tabelaClientes (nome, email, cpf, rg, endereco, telefone, horario, login, senha, perfil)values(?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, r.getNome());
            stmt.setString(2, r.getEmail());
            stmt.setString(3, r.getCpf());
            stmt.setString(4, r.getRg());
            stmt.setString(5, r.getEndereco());
            stmt.setString(6, r.getTelefone());
            stmt.setString(7, r.getHorario());
            stmt.setString(8, r.getLogin());
            stmt.setString(9, r.getSenha());
            stmt.setString(10, r.getPerfil());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Recepcionista> listar() {
        List<Recepcionista> recepcionistas = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM tabelaClientes where perfil = 'Recepcionista' ");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Recepcionista r = new Recepcionista();

                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setEmail(rs.getString("email"));
                r.setCpf(rs.getString("cpf"));
                r.setEndereco(rs.getString("endereco"));
                r.setTelefone(rs.getString("telefone"));
                r.setHorario(rs.getString("horario"));
                r.setLogin(rs.getString("login"));
                r.setSenha(rs.getString("senha"));

                recepcionistas.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

            return recepcionistas;
        }
    }

    }

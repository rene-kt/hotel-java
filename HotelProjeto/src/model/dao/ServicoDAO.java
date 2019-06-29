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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Servico;

/**
 *
 * @author rene_
 */
public class ServicoDAO {

    public void salvar(Servico s) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into servicos(nome, preco, horario, categoria) values (?,?,?,?)");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            stmt.setString(1, s.getNome());
            stmt.setFloat(2, s.getPreco());
            stmt.setString(3, s.getHorario());
            stmt.setString(4, s.getCategoria());

            int add = stmt.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Servico> listar() {

        List<Servico> servicos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("select * from servicos");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico s = new Servico();

                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setPreco(rs.getFloat("preco"));
                s.setHorario(rs.getString("horario"));
                s.setCategoria(rs.getString("categoria"));

                servicos.add(s);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return servicos;
    }
    public void promocao(Servico q) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE servicos set preco = ?,promocao = ? where id =?");

            stmt.setFloat(1, q.getPreco());
            stmt.setInt(3, q.getId());
            stmt.setString(2, q.getPromocao());
            
            int add = stmt.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null, "Promoção efetuada com sucesso!");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
    public List<Servico> listarPromoções() {
        List<Servico> Servicos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("select nome, horario, preco,categoria from servicos where Promocao = 'Promoção'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico q = new Servico();
                q.setNome(rs.getString("nome"));
                q.setHorario(rs.getString("horario"));
                q.setPreco(rs.getFloat("preco"));
                q.setCategoria(rs.getString("categoria"));


                Servicos.add(q);

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Servicos;
    }

}

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Hospede;
import model.bean.Quarto;

/**
 *
 * @author rene_
 */
public class QuartoDAO {

    public void salvar(Quarto q) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into tabelaquartos (numQuarto, Id, preco, disponibilidade,andar,horario)values(?,?,?,?,?,?)");

            stmt.setString(1, q.getNumQuarto());
            stmt.setInt(2, q.getId());
            stmt.setFloat(3, q.getPreco());
            stmt.setString(4, q.getDisponivel());
            stmt.setString(5, q.getAndar());
            stmt.setString(6, q.getHorario());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Quarto cadastrado com sucesso!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Quarto> listar() {
        List<Quarto> quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM tabelaquartos");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Quarto q = new Quarto();

                q.setId(rs.getInt("id"));
                q.setPreco(rs.getFloat("preco"));
                q.setNumQuarto(rs.getString("NumQuarto"));
                q.setAndar(rs.getString("andar"));
                q.setDisponivel(rs.getString("disponibilidade"));
                q.setHorario(rs.getString("horario"));

                quartos.add(q);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return quartos;

    }

    public List<Quarto> listarDisp() {
        List<Quarto> quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM tabelaquartos where disponibilidade!='indisponível'");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Quarto q = new Quarto();

                q.setId(rs.getInt("id"));
                q.setPreco(rs.getFloat("preco"));
                q.setNumQuarto(rs.getString("NumQuarto"));
                q.setAndar(rs.getString("andar"));
                q.setDisponivel(rs.getString("disponibilidade"));
                q.setHorario(rs.getString("horario"));

                quartos.add(q);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return quartos;

    }

    public List<Quarto> listar_usados() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Quarto> quartos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select numQuarto, preco, andar, acumulador from tabelaquartos order by acumulador desc");
            
            rs = stmt.executeQuery();
            while(rs.next()){
                Quarto q = new Quarto();
                q.setPreco(rs.getFloat("preco"));
                q.setNumQuarto(rs.getString("NumQuarto"));
                q.setAndar(rs.getString("andar"));
                q.setAcumulador(rs.getInt("acumulador"));
                
                quartos.add(q);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return quartos;
    }

    public void editar(Quarto q) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tabelaquartos set hospedes = ?, disponibilidade = ?");

            stmt.setString(1, q.getHospede());
            stmt.setString(2, q.getDisponivel());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Quarto> listarReservas() {
        List<Quarto> Quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(" select tabelaclientes.nome,tabelaclientes.horario, tabelaclientes.cpf, tabelaquartos.preco, tabelaquartos.andar,  tabelaquartos.numQuarto from tabelaclientes join tabelaquartos on tabelaquartos.id = tabelaclientes.idquartos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede h = new Hospede();
                Quarto q = new Quarto();

                h.setNome(rs.getString("nome"));
                h.setCpf(rs.getString("cpf"));
                h.setHorario(rs.getString("horario"));
                q.setPreco(rs.getFloat("preco"));
                q.setAndar(rs.getString("andar"));
                q.setNumQuarto(rs.getString("numQuarto"));

                Quartos.add(q);

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Quartos;
    }

    public void promocao(Quarto q) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tabelaquartos set preco = ?, disponibilidade = ? where id =?");

            stmt.setFloat(1, q.getPreco());
            stmt.setString(2, q.getDisponivel());
            stmt.setInt(3, q.getId());

            int add = stmt.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Promoção efetuada com sucesso!");
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void reservado(Quarto q) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tabelaquartos set  disponibilidade = ?,acumulador = acumulador +  ? where id =?");

            stmt.setString(1, q.getDisponivel());
            stmt.setInt(2, q.getAcumulador());
            stmt.setInt(3, q.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void AtualizandoQuarto(Quarto q) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update tabelaquartos set disponibilidade = ? where id = ?");
            stmt.setString(1, q.getDisponivel());
            stmt.setInt(2, q.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Quarto> listarPromoções() {
        List<Quarto> Quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List[] vetor = new List[1];

        try {
            stmt = con.prepareStatement("select numquarto, andar, preco from tabelaquartos where disponibilidade = 'Promoção'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Quarto q = new Quarto();

                q.setPreco(rs.getFloat("preco"));
                q.setAndar(rs.getString("andar"));
                q.setNumQuarto(rs.getString("numQuarto"));

                Quartos.add(q);

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Quartos;
    }
}

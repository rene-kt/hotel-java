/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import View.TelasGerente.EditarReservas;
import View.TelasGerente.MenuGerente;
import View.TelasRecepcionista.MenuRecepcionista;
import View.TelasRecepcionista.ReservarQuarto;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
public class HospedeDAO {

    public void salvar(Hospede h) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into tabelaclientes (nome, email, cpf, endereco, telefone,login, senha,perfil)values(?,?,?,?,?,?,?,?)");

            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getEmail());
            stmt.setString(3, h.getCpf());
            stmt.setString(4, h.getEndereco());
            stmt.setString(5, h.getTelefone());
            stmt.setString(6, h.getLogin());
            stmt.setString(7, h.getSenha());
            stmt.setString(8, h.getPerfil());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void modificar_senha(Hospede h) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update tabelaclientes set senha = ? where cpf = ?");

            stmt.setString(1, h.getSenha());
            stmt.setString(2, h.getCpf());

            int add = stmt.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Senha modificada!");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Hospede> listar() {
        List<Hospede> Hospedes = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM tabelaClientes where perfil = 'Hóspede' ");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede h = new Hospede();

                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setEmail(rs.getString("email"));
                h.setCpf(rs.getString("cpf"));
                h.setEndereco(rs.getString("endereco"));
                h.setHorario(rs.getString("horario"));
                h.setTelefone(rs.getString("telefone"));
                h.setLogin(rs.getString("login"));
                h.setSenha(rs.getString("senha"));
                h.setIdquarto(rs.getInt("idquartos"));

                Hospedes.add(h);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Hospedes;

    }

    public void editar(Hospede h) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tabelaclientes set nome = ?, email = ?, cpf = ?,  endereco = ?, telefone = ?,  login = ?, senha = ? WHERE id = ? ");
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getEmail());
            stmt.setString(3, h.getCpf());
            stmt.setString(4, h.getEndereco());
            stmt.setString(5, h.getTelefone());
            stmt.setString(6, h.getLogin());
            stmt.setString(7, h.getSenha());
            stmt.setInt(8, h.getId());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void reservarQuarto(Hospede h) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(" update tabelaclientes set idquartos=?, horario=? where id = ?");

            stmt.setInt(1, h.getIdquarto());
            stmt.setInt(3, h.getId());
            stmt.setString(2, h.getHorario());

            int add = stmt.executeUpdate();

            if (add > 0) {
                
                JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso");
                MenuRecepcionista rq = new MenuRecepcionista();
                ReservarQuarto q = new ReservarQuarto();
                q.dispose();
                rq.setVisible(true);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione os campos na tabela ou digite um horário para o cliente ser hospedado.");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    

    public List<Hospede> listarReservas() {
        List<Hospede> Hospedes = new ArrayList<>();
        List<Quarto> Quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("select tabelaclientes.nome,tabelaclientes.id, tabelaclientes.idquartos, tabelaclientes.horario, tabelaclientes.gastos,tabelaclientes.cpf, tabelaquartos.andar,tabelaquartos.numQuarto, tabelaquartos.preco from tabelaclientes join tabelaquartos on tabelaclientes.idquartos = tabelaquartos.id");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede h = new Hospede();
                Quarto quarto = new Quarto();

                h.setNome(rs.getString("nome"));
                h.setId(rs.getInt("id"));
                h.setCpf(rs.getString("cpf"));
                h.setHorario(rs.getString("horario"));
                h.setIdquarto(rs.getInt("idquartos"));
                h.setAcumuladorPreco(rs.getFloat("gastos"));

                quarto.setNumQuarto(rs.getString("numQuarto"));
                quarto.setPreco(rs.getFloat("preco"));
                quarto.setAndar(rs.getString("andar"));
                h.setNomeQuarto(quarto);
                h.setAndar(quarto);
                h.setPrecoQuarto(quarto);

                Hospedes.add(h);

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Hospedes;
    }

    public List<Hospede> listarHospDisponiveis() {
        List<Hospede> Hospedes = new ArrayList<>();
        List<Quarto> Quartos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List[] vetor = new List[1];

        try {
            stmt = con.prepareStatement("select * from tabelaclientes where perfil = 'Hóspede' and idquartos='0'");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede h = new Hospede();

                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setEmail(rs.getString("email"));
                h.setCpf(rs.getString("cpf"));
                h.setEndereco(rs.getString("endereco"));
                h.setHorario(rs.getString("horario"));
                h.setTelefone(rs.getString("telefone"));
                h.setLogin(rs.getString("login"));
                h.setSenha(rs.getString("senha"));
                h.setIdquarto(rs.getInt("idquartos"));
                h.setAcumuladorPreco(rs.getFloat("gastos"));

                Hospedes.add(h);

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Hospedes;
    }
     public void gastosServicos_salao(Hospede h) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(" update tabelaclientes set gastos=gastos + ? where id = ?");

            stmt.setFloat(1, h.getAcumuladorPreco());
            stmt.setInt(2, h.getId());

             stmt.executeUpdate();

          

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    

    
    public void gastosServicos(Hospede h) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(" update tabelaclientes set gastos=gastos + ? where id = ?");

            stmt.setFloat(1, h.getAcumuladorPreco());
            stmt.setInt(2, h.getId());

            int add = stmt.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Efetuado com sucesso!");
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    

    public void inserir_idAuxiliar(Hospede h) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update tabelaclientes set idaux = ? where id = ?");

            stmt.setInt(1, h.getIdaux());
            stmt.setInt(2, h.getId());

            int add = stmt.executeUpdate();

            if (add > 0) {
                System.out.println("deu certo");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void fecharEstadia(Hospede h) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update tabelaclientes set idquartos = ? , gastos = ? where id = ?");

            stmt.setInt(1, h.getIdquarto());
            stmt.setFloat(2, h.getAcumuladorPreco());
            stmt.setInt(3, h.getId());

            int add = stmt.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Fechamento realizado com sucesso!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void editar_reserva(Hospede h){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("update  tabelaclientes  set nome = ?, cpf = ?, gastos = ?, horario = ? where id =?");

            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getCpf());
            stmt.setFloat(3, h.getAcumuladorPreco());
            stmt.setString(4, h.getHorario());
            stmt.setInt(5, h.getId());
            
            int add = stmt.executeUpdate();
            
            if(add>0){
                JOptionPane.showMessageDialog(null, "Reserva editada com sucesso!");
                MenuGerente g = new MenuGerente();
                EditarReservas r = new EditarReservas();
                
                r.dispose();
                g.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
    ConnectionFactory.closeConnection(con, stmt);
}
        
    }

}

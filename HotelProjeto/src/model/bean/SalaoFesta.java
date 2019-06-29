/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author rene_
 */
public class SalaoFesta {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private int id;
    private float preco;
    private String disponibilidade;
    private String horario;

    
    
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

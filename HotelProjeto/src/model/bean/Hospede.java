package model.bean;

import java.text.SimpleDateFormat;

/**
 *
 * @author rene_
 */
public class Hospede {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String telefone;
    private String horario;
    private String login;
    private String senha;
    private String perfil;
    private String rg;
    private int idquarto;
    private float acumuladorPreco;
    private Quarto precoQuarto;
    private Quarto nomeQuarto;
    private Quarto andar;
    private static int idaux;

    public static int getIdaux() {
        return idaux;
    }

    public static void setIdaux(int idaux) {
        Hospede.idaux = idaux;
    }

  

    public Quarto getAndar() {
        return andar;
    }

    public void setAndar(Quarto andar) {
        this.andar = andar;
    }

    public Quarto getPrecoQuarto() {
        return precoQuarto;
    }

    public void setPrecoQuarto(Quarto precoQuarto) {
        this.precoQuarto = precoQuarto;
    }

    public Quarto getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(Quarto nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public float getAcumuladorPreco() {
        return acumuladorPreco;
    }

    public void setAcumuladorPreco(float acumuladorPreco) {
        this.acumuladorPreco = acumuladorPreco;
    }

    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquarto) {
        this.idquarto = idquarto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

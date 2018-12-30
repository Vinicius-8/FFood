package controller;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Vinicius
 */
@MappedSuperclass
public class Usuario implements Serializable{
    
    @Id
    private String cpf;
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}

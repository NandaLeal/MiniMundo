
package br.edu.ifnmg.projetoPOO;

/**
 *
 * @author Filipi
 * @version 1.1
 */

public class Usuario {
    
    private String nome;
    private String senha;
    private String email;
    private int ddd;
    private int fone;
    private boolean admin;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public int getDdd() {
        return ddd;
    }

    public int getFone() {
        return fone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}

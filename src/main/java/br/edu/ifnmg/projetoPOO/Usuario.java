
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}

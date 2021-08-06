package br.edu.ifnmg.projetoPOO;

/**
 *
 * @author Filipi
 * @version 1.1
 */

public class Cliente {
    
    private String nome;
    private String endereco;
    private String email;
    private int ddd;
    private int fone;
    private long cpf;
    private boolean mensalista = false;
    private boolean inadimplente = true;
    private long id;


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
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

    public long getCpf() {
        return cpf;
    }

    public boolean isInadimplente() {
        return inadimplente;
    }

    public boolean isMensalista() {
        return mensalista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setMensalista(boolean mensalista) {
        this.mensalista = mensalista;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
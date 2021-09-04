package br.edu.ifnmg.projetoPOO;

import com.toedter.calendar.JCalendar;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Filipi
 * @version 1.2
 */

public class Cliente {
    
    private String nome;
    private String endereco;
    private String email;
    private int ddd;
    private long fone;
    private Long cpf;
    private Fatura fatura;
    private Veiculo veiculo;
    

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
    
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

    public long getFone() {
        return fone;
    }

    public Long getCpf() {
        return cpf;
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

    public void setFone(long fone) {
        this.fone = fone;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    
}

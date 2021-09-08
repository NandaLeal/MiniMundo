package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;
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

public class Cliente extends Entidade{
    
    private String nome;
    private String endereco;
    private String email;
    private Long ddd;
    private Long fone;
    private Long cpf;
    private Veiculo veiculo;
    
    public Cliente(){
        
    }
    
    /**
     * @param id
     * @param nome
     * @param endereco
     * @param email
     * @param ddd
     * @param fone
     * @param cpf
     * @param veiculo 
     */
    public Cliente(Long id, String nome, String endereco, String email, 
                           Long ddd, Long fone, Long cpf){
        super(id);
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.ddd = ddd;
        this.fone = fone;
        this.cpf = cpf;
        this.veiculo = veiculo;            
    }
    
    

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public Long getDdd() {
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

    public void setDdd(Long ddd) {
        this.ddd = ddd;
    }

    public void setFone(Long fone) {
        this.fone = fone;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    
}

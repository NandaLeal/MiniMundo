
package br.edu.ifnmg.projetoPOO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class Ticket {
    
    private int id;
    private LocalDate entrada;
    private String placa;
    private String descricaoVeiculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }
    
    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String observacao) {
        this.descricaoVeiculo = observacao;
    }
    
    
}

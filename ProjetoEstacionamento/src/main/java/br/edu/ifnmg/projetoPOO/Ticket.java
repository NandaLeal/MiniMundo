
package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.Entidade;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class Ticket extends Entidade{
    

    private LocalDate entrada;
    private String placa;
    private String descricaoVeiculo;

  

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

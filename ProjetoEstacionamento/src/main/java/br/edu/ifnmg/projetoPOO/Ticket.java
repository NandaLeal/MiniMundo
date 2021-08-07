
package br.edu.ifnmg.projetoPOO;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Ticket {
    
    private Date entrada;
//    private Date saida;
//    private DecimalFormat valor;
    private String observacao;
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public DecimalFormat getValor() {
        return valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public void setValor(DecimalFormat valor) {
        this.valor = valor;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}

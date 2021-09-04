
package br.edu.ifnmg.projetoPOO;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Veiculo{
    
    private String modelo;
    private String cor;
    private String placa;
    private String tipo;
    
    /**
     * Cria um novo veículo
     */
    public Veiculo(){
        
    }
    
    /**
     * 
     * @param modelo Representa o modelo do carro
     * @param cor Representa a cor do veículo
     * @param placa Representa a placa do veículo
     * @param tipo Representa o tipo do veículo
     */
    public Veiculo(String modelo, String cor, String placa, String tipo){
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipo = tipo;        
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

   
}

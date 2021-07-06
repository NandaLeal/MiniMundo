/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.pessoa;

/**
 *Criando Pessoa
 * @author USER
 */
public class ID {
    private String nome;
    private int idade;

    public ID(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public ID() {
        this.nome = nome;
        this.idade = idade;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
   
    //</editor-fold>
    
}

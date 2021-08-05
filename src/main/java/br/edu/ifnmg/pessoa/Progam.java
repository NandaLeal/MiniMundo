/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.pessoa;
import javax.swing.JOptionPane;

/**
 *Executar os comandos
 * @author USER
 */
public class Progam {
    public static void main(String[] args) {
    ID p1 = new ID();
    
    //System.out.println("<<Nome:" +  p1.getNome());
    //System.out.println("<<Idade:" +  p1.getIdade());
    
    String nome = JOptionPane.showInputDialog("Qual nome?");
    p1.setNome(nome);
    System.out.println("<<Nome:" +  p1.getNome()); 
    
   String entradaIda = JOptionPane.showInputDialog("Qual idade?");
   int ida = Integer.parseInt(entradaIda);
   p1.setIdade(ida);
   System.out.println("<<Idade:" +  p1.getIdade());
    
    
    
    
    }
    
}

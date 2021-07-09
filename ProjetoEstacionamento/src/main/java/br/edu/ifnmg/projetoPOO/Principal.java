
package br.edu.ifnmg.projetoPOO;

import java.util.Scanner;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Principal {
    
    public static Usuario user1 = new Usuario();
    
    public static void main(String[] args) {
        
        /*
            Tudo que foi implementado na classe Principal
            é apenas pra teste. Geters e Seters de Usuário 
            estão funcionando bem.
        */
        
        Scanner scan = new Scanner(System.in);  // Invoco a função Scanner pra ler input do teclado
        String senhaTeclado;
        
        // Set dos atributos de um usuário
        user1.setNome("Filipi");
        user1.setAdmin(true);
        user1.setDdd(38);
        user1.setEmail("fmrj@aluno");
        user1.setFone(992160517);
        
        System.out.println("Informe a senha: ");        
        senhaTeclado = scan.nextLine(); // Leio input do teclado, guardo em "senhaTeclado"
        user1.setSenha(senhaTeclado);
        
        System.out.println(user1.getSenha());
        System.out.println(user1.getNome());
        System.out.println(user1.getFone());
        System.out.println(user1.getDdd());
        System.out.println(user1.getEmail());
        
    
    }
}

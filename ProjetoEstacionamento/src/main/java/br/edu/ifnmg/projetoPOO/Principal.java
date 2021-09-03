
package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.ClienteDao;
import br.edu.ifnmg.projetoPOO.dao.UsuarioDao;
import java.util.Scanner;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Principal {
        
    public static void main(String[] args) {
       
        
        
        
         // Inclusão de novo usuário
        //
        Usuario usuarioA = new Usuario(null, "Filipi", "filipi@mail.com", "123456", true);
        new UsuarioDao().salvar(usuarioA);
        System.out.println(">> Novo usuário ADMIN inserido no banco de dados");
        
        Usuario usuarioB = new Usuario(null, "Comum", "comum@mail.com", "123456", false);
        new UsuarioDao().salvar(usuarioB);
        System.out.println(">> Novo usuário COMUM inserido no banco de dados");
        

        //
        // Autenticação de usuário
        //
        Usuario usuarioC = new Usuario();
        usuarioC.setEmail("filipi@mail.com");
        usuarioC.setSenha("123456");
        
        Usuario usuarioAutenticado = new UsuarioDao().autenticar(usuarioC);
        if(usuarioAutenticado != null) {
            System.out.println(">> Autenticado: " + usuarioAutenticado);
        } else {
            System.out.println(">> Não autenticado.");
        }
        
    
    }
}


package br.edu.ifnmg.projetoPOO;

import br.edu.ifnmg.projetoPOO.dao.ClienteDao;
import java.util.Scanner;

/**
 *
 * @author Filipi
 * @version 1.1
 */
public class Principal {
        
    public static void main(String[] args) {
       
        Cliente cliente = new Cliente();
        cliente.setNome("Filipi");
        cliente.setId(22);
        
        ClienteDao clienteDao = new ClienteDao();
//        clienteDao.salvar(cliente);
//        clienteDao.localizarPorId(2L);
//        clienteDao.localizarTodos();
//        clienteDao.excluir(cliente);
        

        
        
    
    }
}

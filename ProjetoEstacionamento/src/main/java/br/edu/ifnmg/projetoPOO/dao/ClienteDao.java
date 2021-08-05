/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Cliente;
import java.util.List;
import br.edu.ifnmg.projetoPOO.gui.CadastroCliente;

/**
 *
 * @author Filip
 */
public class ClienteDao implements IDao<Cliente, Long>{

    @Override
    public Long salvar(Cliente o) {
        
        if(o.getId() == 0){
            System.out.println("insert into cliente (nome) values ('"+ o.getNome() +"');");
        }else{
            System.out.println("update cliente set nome = '"+ o.getNome() +"' where id = "+ o.getId() +";");
        }
        return 0L;           
    }

    @Override
    public Cliente localizarPorId(Long id) {
        System.out.println("select * from cliente where id = "+ id +";");        
        return null;
    }

    @Override
    public List<Cliente> localizarTodos() {
        System.out.println("select * from cliente");        
        return null;
    }

    @Override
    public void excluir(Cliente o) {
        // delete from cliente where id = 2;
        System.out.println("select * from cliente where id = "+ o.getId() +";");        
        
    }
    
}

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
 * @author Filipi
 * @version 1.2
 */
public class ClienteDao implements IDao<Cliente, Long>{

    @Override
    public Long salvar(Cliente o) {
        System.out.println("insert into cliente (nome, email, endereco, cpf, ddd, fone) values "
                + "('"+o.getNome()+"', '"+o.getEmail()+"', '"+o.getEndereco()+"', '"+o.getCpf()+"', "
                 + "'"+o.getDdd()+"', '"+o.getFone()+"');");
        return 0L;           
    }

    @Override //id do cliente é o cpf
    public Cliente localizarPorId(Long cpf) { 
        System.out.println("select * from cliente where cpf = '"+ cpf +"';");       
        return null;
    }

    @Override
    public List<Cliente> localizarTodos() {
        System.out.println("select * from cliente");        
        return null;
    }

    @Override
    public void excluir(Cliente o) {
        System.out.println("select * from cliente where cpf = '"+ o.getCpf() +"';");
    }

    
}

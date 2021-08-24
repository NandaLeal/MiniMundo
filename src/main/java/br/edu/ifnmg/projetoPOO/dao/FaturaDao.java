/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Fatura;
import java.util.List;

/**
 *
 * @author Filip
 */
public class FaturaDao implements IDao<Fatura, Long>{

    @Override
    public Long salvar(Fatura o) {
        
        System.out.println("insert into fatura (dataEmissao, diaVencimento, valor, cpfCliente) values "
        + "('"+o.getDataEmissao()+"', '"+o.getDiaVencimento()+"', '"+o.getValor()+"', '"+o.getCliente().getCpf()+"');");
        
        return 0L; 
    }

    @Override
    public List<Fatura> localizarTodos() {
        System.out.println("select * from fatura");        
        return null;
    }

    @Override
    public void excluir(Fatura o) {
        System.out.println("select * from fatura where cpf = '"+o.getCliente().getCpf()+"' and dataEmissao = '"+o.getDataEmissao()+"';");
    }

    @Override   // id é o cpf do cliente na fatura
    public Fatura localizarPorId(Long cpf) {
        System.out.println("select * from fatura where cpf = '"+ cpf +"';");  
        return null;
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Veiculo;
import java.util.List;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class VeiculoDao implements IDao<Veiculo, Long>{

    @Override
    public Long salvar(Veiculo o){
        
        System.out.println("insert into veiculo (modelo, cor, placa) values "
        + "('"+o.getModelo()+"', '"+o.getCor()+"', '"+o.getPlaca()+"');");
        return 0L;
    }

    public Veiculo localizarPorPlaca(String placa){
        System.out.println("select * from veiculo where placa = "+ placa +";");
        return null;
    }

    @Override
    public List<Veiculo> localizarTodos() {
        System.out.println("select * from veiculo;");
        return null;
    }

    @Override
    public void excluir(Veiculo o) {
        System.out.println("select from veiculo where placa = "+o.getPlaca()+";");
    }

    @Override   // O veiculo não possui um id do tipo Long. Metodo não será usado.
    public Veiculo localizarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

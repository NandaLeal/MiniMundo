/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Usuario;
import java.util.List;

/**
 *
 * @author Filip
 */
public class UsuarioDao implements IDao<Usuario, Long>{
 

    @Override
    public Long salvar(Usuario o) {
       System.out.println("insert into usuario (nome, email, senha, admin) values "
               + "('"+o.getNome()+"', '"+o.getEmail()+"', '"+o.getSenha()+"', '"+o.isAdmin()+"');");
    return 0L;
    }

    @Override
    public Usuario localizarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> localizarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

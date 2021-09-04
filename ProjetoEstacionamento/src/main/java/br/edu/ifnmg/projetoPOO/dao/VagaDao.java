/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Usuario;
import br.edu.ifnmg.projetoPOO.Vaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class VagaDao extends AbstractDao<Vaga, Long>{
    
    
      
    
    
    
    
    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO vaga (placa, descricao, numero_vaga) VALUES (?, ?, ?);";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM vaga WHERE placa = ?;";
    }
//    public String getDeclaracaoSelectPorPlaca() {
//         return "SELECT * FROM vaga WHERE placa = ?;";
//    }
//
//    
//    public String getDeclaracaoSelectTodos() {
//         return "SELECT * FROM usuario";
//    }
//
//    
//    public String getDeclaracaoUpdate() {
//        return "UPDATE usuario SET nome = ?, email = ?, senha = MD5(?), administrador = ? WHERE id = ?;";
//    }

    @Override
    public String getDeclaracaoSelectPorId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeclaracaoUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Vaga o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vaga extrairObjeto(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vaga> extrairObjetos(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}

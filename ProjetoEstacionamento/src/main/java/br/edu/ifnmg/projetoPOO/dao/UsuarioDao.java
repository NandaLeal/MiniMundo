/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        System.out.println("select from usuario where email = '"+o.getEmail()+"' and senha = '"+o.getSenha()+"';");
    }

    @Override
    public List<Usuario> localizarTodos() {
        System.out.println("select * from usuario;");
        return null;
    }
    
    
    public Usuario extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem da tarefa
        Usuario usuario = new Usuario();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado da tarefa a ser mapeada
        try {
            usuario.setId(resultSet.getLong("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdmin(resultSet.getBoolean("administrador"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return usuario;
    }
    
    public Usuario autenticar(Usuario usuario) {
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para validação de usuário
                        "SELECT * "
                        + "FROM usuario "
                        + "WHERE email = ? "
                        + "AND senha = MD5(?)")) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getSenha());

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... implica que email e senha estão corretos 
                // para o usuário e devolve os dados completos deste
                return extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

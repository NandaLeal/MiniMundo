/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Cliente;
import br.edu.ifnmg.projetoPOO.dao.Entidade;

import br.edu.ifnmg.projetoPOO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class UsuarioDao extends AbstractDao<Usuario, Long>{
    
    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO usuario (nome, email, senha, administrador, cpf) VALUES (?, ?, MD5(?), ?, ?);";
    }

    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM usuario WHERE cpf = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
         return "SELECT * FROM usuario";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE usuario SET nome = ?, email = ?, senha = MD5(?), administrador = ? WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM usuario WHERE email = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Usuario usuario) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
//            if (usuario.getId() != null || usuario.getId() == 0) {
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getSenha());
                pstmt.setBoolean(4, usuario.isAdmin());
                pstmt.setLong(5, usuario.getCpf());
//            } 
//            else {
//                pstmt.setString(1, usuario.getNome());
//                pstmt.setString(2, usuario.getEmail());
//                pstmt.setString(3, usuario.getSenha());
//                pstmt.setBoolean(4, usuario.isAdmin());
//            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem da tarefa
        Usuario usuario = new Usuario();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado da tarefa a ser mapeada
        try {
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdmin(resultSet.getBoolean("administrador"));
            usuario.setCpf(resultSet.getLong("cpf"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return usuario;
    }

    @Override
    public List<Usuario> extrairObjetos(ResultSet resultSet) {

        // Cria referência para inserção das tarefas a serem mapeadas
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem da tarefa
                Usuario usuario = new Usuario();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado da tarefa a ser mapeada
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAdmin(resultSet.getBoolean("administrador"));
                usuario.setCpf(resultSet.getLong("cpf"));

                // Insere a tarefa na lista de tarefas recuperadas
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de tarefas reconstituídas dos registros do banco 
        // de dados
        return usuarios;
    }

   
    
    public Usuario autenticar(Usuario usuario) {
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para validação de usuário
                        "SELECT * "
                        + "FROM tcdpoo.usuario "
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


    @Override
    public Boolean excluir(Usuario usuario){
        // Recupera a identidade (chave primária) do objeto a ser excluído
        String email = ((Usuario) usuario).getEmail();
        
        // Se há uma identidade válida...
        if (email != null) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Declaração com parametro                 
                pstmt.setString(1, ((Usuario) usuario).getEmail() );

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }

    

    
}




/*

    public void montarDeclaracaoExcluirUsuario(PreparedStatement pstmt, Usuario usuario) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
                pstmt.setString(1, usuario.getEmail() );

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

*/